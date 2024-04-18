package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Cart {
    public static final int smallestGroupPossible = 2;
    private List<Book> cartItems;

    public Cart() {
        cartItems = new ArrayList<Book>();
    }

    public void addItems(Book[] items) {
        cartItems.addAll(Arrays.asList(items));
    }

    public void clear() {
        cartItems.clear();
    }

    public float calculateBestPrice() {

        Map<Boolean, List<Book>> partitionBetweenOfferAndNotOfferBooks = cartItems
                .stream()
                .collect(Collectors.partitioningBy(basketItem -> App.allowedBookTypes.contains(basketItem)));

        List<Book> booksWithSpecialOffer = partitionBetweenOfferAndNotOfferBooks.get(true);

        LinkedHashMap<String, List<Book>> booksGrouped = getBooksGroupedAndSorted(booksWithSpecialOffer);

        float maxDiscount = recursiveMaxDiscount(booksGrouped, 0);
        float totalCartPrice = cartItems.size() * Book.price;

        return totalCartPrice - maxDiscount;
    }

    public float recursiveMaxDiscount(Map<String, List<Book>> booksGrouped, int currentGroup) {

        float discountAccumulator = 0;
        Iterator<String> iterator = booksGrouped.keySet().iterator();
        for (int i = 1; i <= currentGroup; i++) {
            String key = iterator.next();
            discountAccumulator += booksGrouped.get(key).remove(0).getPrice() * Book.discounts.get(currentGroup);
        }

        booksGrouped.entrySet().removeIf(entry -> entry.getValue().size() == 0);

        if (booksGrouped.size() < smallestGroupPossible) {
            return discountAccumulator;
        } else {
            float max = 0;
            for (int i = smallestGroupPossible; i <= booksGrouped.size(); i++) {
                LinkedHashMap<String, List<Book>> remainingBooks = getBooksCopy(booksGrouped);
                max = Math.max(max, recursiveMaxDiscount(remainingBooks, i));
            }
            return discountAccumulator + max;
        }
    }

    public LinkedHashMap<String, List<Book>> getBooksCopy(Map<String, List<Book>> list) {
        LinkedHashMap<String, List<Book>> copy = new LinkedHashMap<>();
        for (Map.Entry<String, List<Book>> entry : list.entrySet()) {
            List<Book> copyList = new ArrayList<>();
            copyList.addAll(entry.getValue());
            copy.put(entry.getKey(), copyList);
        }
        return copy;
    }

    public LinkedHashMap<String, List<Book>> getBooksGroupedAndSorted(List<Book> listOfBooks) {
        Map<String, List<Book>> booksGroupedByTitle = listOfBooks
                .stream()
                .collect(Collectors.groupingBy(Book::getTitle));

        Set<Entry<String, List<Book>>> entries = booksGroupedByTitle.entrySet();

        List<Entry<String, List<Book>>> listOfEntries = new ArrayList<Entry<String, List<Book>>>(entries);
        Collections.sort(listOfEntries, mapComparator);
        LinkedHashMap<String, List<Book>> linkedHashMap = new LinkedHashMap<String, List<Book>>(listOfEntries.size());
        for (Entry<String, List<Book>> entry : listOfEntries) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        return linkedHashMap;
    }

    Comparator<Entry<String, List<Book>>> mapComparator = new Comparator<Entry<String, List<Book>>>() {

        @Override
        public int compare(Entry<String, List<Book>> e1, Entry<String, List<Book>> e2) {
            return e2.getValue().size() - e1.getValue().size();
        }
    };

    /*
     * public float calculateBestPrice() {
     * Map<Boolean, List<Book>> partitionBetweenOfferAndNotOfferBooks = cartItems
     * .stream()
     * .collect(Collectors.partitioningBy(basketItem ->
     * App.allowedBookTypes.contains(basketItem)));
     * 
     * List<Book> booksWithSpecialOffer =
     * partitionBetweenOfferAndNotOfferBooks.get(true);
     * 
     * // libro1 => x, libro2 => y, libro3 => z
     * BooksGroupedByType booksGroupedByType =
     * groupBooksByType(booksWithSpecialOffer);
     * 
     * // [x,y,z]
     * List<Integer> valuesOfEachTypeOfBook = booksGroupedByType
     * .getList()
     * .values()
     * .stream()
     * .sorted(Comparator.reverseOrder())
     * .collect(Collectors.toList());
     * 
     * float maxDiscount = recursiveMaxDiscount(valuesOfEachTypeOfBook, 0);
     * float totalCartPrice = cartItems.size() * Book.price;
     * 
     * return totalCartPrice - maxDiscount;
     * }
     * 
     * public float recursiveMaxDiscount(List<Integer> booksGroups, int
     * currentGroup) {
     * 
     * float accumulator = 0;
     * 
     * for (int i = 1; i <= currentGroup; i++) {
     * accumulator += Book.price * Book.discounts.get(currentGroup);
     * booksGroups.set(i - 1, booksGroups.get(i - 1) - 1);
     * }
     * booksGroups.removeIf(group -> group == 0);
     * if (booksGroups.size() <= 1) {
     * return accumulator;
     * } else {
     * float max = 0;
     * for (int i = smallestGroupPossible; i <= booksGroups.size(); i++) {
     * List<Integer> remainingBooks = new ArrayList<>(booksGroups);
     * max = Math.max(max, recursiveMaxDiscount(remainingBooks, i));
     * }
     * return accumulator + max;
     * }
     * }
     * 
     * public static BooksGroupedByType groupBooksByType(List<Book> booksList) {
     * Set<Book> differentTypesOfBooks = new HashSet<Book>(booksList);
     * BooksGroupedByType booksGroupedByType = new BooksGroupedByType();
     * for (Book book : differentTypesOfBooks) {
     * Integer appearancesOfGivenBook = booksList.stream()
     * .filter(bookInBasket -> bookInBasket.equals(book))
     * .collect(Collectors.toList())
     * .size();
     * booksGroupedByType.put(book.getTitle(), appearancesOfGivenBook);
     * }
     * return booksGroupedByType;
     * }
     */

    /*************************************************************************** */

}
