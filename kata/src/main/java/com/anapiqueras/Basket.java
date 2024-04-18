package com.anapiqueras;

import java.util.ArrayList;

public class Basket {

    private ArrayList<Book> books = new ArrayList<Book>();

    public Basket() {

    }

    public void addBook(Book b) throws BasketFullException {
        if(books.size()>20){
            throw new BasketFullException("The basket is full");
        }
        books.add(b);
    }

    public void emptyBasket(){
        books.clear();
    }

}
