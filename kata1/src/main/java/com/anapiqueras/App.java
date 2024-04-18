package com.anapiqueras;

public class App {

    private static final int PRICE_BOOK = 8;
    private static final double[] DISCOUNTS = { 0.0, 0.05, 0.10, 0.20, 0.25 };
    private static final String[] BOOKS = { "book1", "book2", "book3", "book4", "book5" };

    public static int getPriceBook() {
        return PRICE_BOOK;
    }

    public static double[] getDiscounts() {
        return DISCOUNTS;
    }

    public static String[] getBooks() {
        return BOOKS;
    }

    public static void main(String[] args) {
        String[] list = { "book1", "book1", "book2", "book2", "book3", "book3", "book4", "book5" };
        /* String[] list = { }; */
        System.out.println("Precio: " + calculatePriceBooks(list));
    }

    // -- Calcula el mejor precio, probando todas las combinaciones
    public static double calculatePriceBooks(String[] list) {
        double[] costByGroups = { 0.0, 0.0, 0.0, 0.0, 0.0 };
        int[] groups = createGroupsOfBooks(list);
        // System.out.println("----" + Arrays.toString(costByGroups));
        costByGroups[0] = costByGroupsOf1(groups);
        // System.out.println("----" + Arrays.toString(costByGroups));
        costByGroups[1] = costByGroupsOf2(groups);
        // System.out.println("----" + Arrays.toString(costByGroups));
        costByGroups[2] = costByGroupsOf3(groups);
        // System.out.println("----" + Arrays.toString(costByGroups));
        costByGroups[3] = costByGroupsOf4(groups);
        // System.out.println("----" + Arrays.toString(costByGroups));
        costByGroups[4] = costByGroupsOf5(groups);
        // System.out.println("----" + Arrays.toString(costByGroups));

        return calculateCostMin(costByGroups);
    }

    // -- Calcula el precio mínimo de cada posible combinación de libros
    public static double calculateCostMin(double[] costByGroups) {
        double max_value = 9999999;
        double costMin = max_value;
        for (int i = 0; i < costByGroups.length; i++) {
            if (costByGroups[i] < costMin && costByGroups[i] > 0) {
                costMin = costByGroups[i];
            }
        }
        // System.out.println(Arrays.toString(costByGroups));
        if (costMin == max_value) {
            return 0.0;
        }
        return costMin;

    }

    // -- Calcula el precio de lotes de 1 libro
    public static double costByGroupsOf1(int[] bookGroups) {
        double[] costGroup1 = { 0.0 };
        int[] newBookGroups = { bookGroups[0], bookGroups[1], bookGroups[2], bookGroups[3], bookGroups[4] };
        int numDifBooks = 0;
        int i = 0;
        while (numDifBooks != 1 && i < bookGroups.length) {
            if (bookGroups[i] > 0) {
                numDifBooks++;
                newBookGroups[i]--;
            }
            i++;
        }
        if (numDifBooks == 1) {
            // System.out.println("costByGroupOf1");
            costGroup1[0] = priceBooks(numDifBooks, DISCOUNTS[numDifBooks - 1]);
            // System.out.println(costGroup1[0]);
            costGroup1[0] += costByGroupsOf1(newBookGroups);
            // System.out.println(costGroup1[0]);
        }
        return costGroup1[0];
    }

    // -- Calcula el precio de lotes de 2 y de 1 libro
    public static double costByGroupsOf2(int[] bookGroups) {
        double[] costGroup2 = { 0.0, 0.0 };
        int[] newBookGroups = { bookGroups[0], bookGroups[1], bookGroups[2], bookGroups[3], bookGroups[4] };
        int numDifBooks = 0;
        int i = 0;
        while (numDifBooks != 2 && i < bookGroups.length) {
            if (bookGroups[i] > 0) {
                numDifBooks++;
                newBookGroups[i]--;
            }
            i++;
        }
        if (numDifBooks == 2) {
            // System.out.println("costByGroupOf2");
            costGroup2[0] = priceBooks(numDifBooks, DISCOUNTS[numDifBooks - 1]);
            // System.out.println(costGroup2[0]);
            costGroup2[0] += costByGroupsOf2(newBookGroups);
            // System.out.println(costGroup2[0]);

        } else {
            costGroup2[1] = costByGroupsOf1(bookGroups);
        }
        return calculateCostMin(costGroup2);
    }

    // -- Calcula el precio de lotes de 3, de 2 y de 1 libro
    public static double costByGroupsOf3(int[] bookGroups) {
        double[] costGroup3 = { 0.0, 0.0, 0.0 };
        int[] newBookGroups = { bookGroups[0], bookGroups[1], bookGroups[2], bookGroups[3], bookGroups[4] };
        int numDifBooks = 0;
        int i = 0;
        while (numDifBooks != 3 && i < bookGroups.length) {
            if (bookGroups[i] > 0) {
                numDifBooks++;
                newBookGroups[i]--;
            }
            i++;
        }
        if (numDifBooks == 3) {
            // System.out.println("costByGroupOf3");

            costGroup3[0] = priceBooks(numDifBooks, DISCOUNTS[numDifBooks - 1]);
            // System.out.println(costGroup3[0]);
            costGroup3[0] += costByGroupsOf3(newBookGroups);
            // System.out.println(costGroup3[0]);

        } else {
            costGroup3[2] = costByGroupsOf2(bookGroups);
            costGroup3[1] = costByGroupsOf1(bookGroups);
        }
        return calculateCostMin(costGroup3);
    }

    // -- Calcula el precio de lotes de 4,3,2 y 1 libro
    public static double costByGroupsOf4(int[] bookGroups) {
        double[] costGroup4 = { 0.0, 0.0, 0.0, 0.0 };
        int[] newBookGroups = { bookGroups[0], bookGroups[1], bookGroups[2], bookGroups[3], bookGroups[4] };
        int numDifBooks = 0;
        int i = 0;
        while (numDifBooks != 4 && i < bookGroups.length) {
            if (bookGroups[i] > 0) {
                numDifBooks++;
                newBookGroups[i]--;
            }
            i++;
        }
        if (numDifBooks == 4) {
            // System.out.println("costByGroupOf4");
            costGroup4[0] = priceBooks(numDifBooks, DISCOUNTS[numDifBooks - 1]);
            // System.out.println(costGroup4[0]);
            costGroup4[0] += costByGroupsOf4(newBookGroups);
            // System.out.println(costGroup4[0]);

        } else {
            costGroup4[3] = costByGroupsOf3(bookGroups);
            costGroup4[2] = costByGroupsOf2(bookGroups);
            costGroup4[1] = costByGroupsOf1(bookGroups);
        }
        return calculateCostMin(costGroup4);
    }

    // -- Calcula el precio de lotes de 5,4,3,2 y 1 libro
    public static double costByGroupsOf5(int[] bookGroups) {
        double[] costGroup5 = { 0.0, 0.0, 0.0, 0.0, 0.0 };
        int numDifBooks = 0;
        int[] newBookGroups = { bookGroups[0], bookGroups[1], bookGroups[2], bookGroups[3], bookGroups[4] };
        for (int i = 0; i < bookGroups.length; i++) {
            if (bookGroups[i] > 0) {
                numDifBooks++;
                newBookGroups[i]--;
            }
        }
        if (numDifBooks == 5) {
            // System.out.println("costByGroupOf5");
            costGroup5[0] = priceBooks(numDifBooks, DISCOUNTS[numDifBooks - 1]);
            // System.out.println(costGroup5[0]);
            costGroup5[0] = costGroup5[0] + costByGroupsOf5(newBookGroups);
            // System.out.println(costGroup5[0]);
        } else {
            costGroup5[4] = costByGroupsOf4(bookGroups);
            costGroup5[3] = costByGroupsOf3(bookGroups);
            costGroup5[2] = costByGroupsOf2(bookGroups);
            costGroup5[1] = costByGroupsOf1(bookGroups);
        }
        return calculateCostMin(costGroup5);
    }

    // -- Método para el cálulo del precio de los libros
    public static double priceBooks(int quantity, double discount) {
        return quantity * PRICE_BOOK * (1 - discount);
    }

    // -- Agrupa los libros iguales en un array
    public static int[] createGroupsOfBooks(String[] list) {
        int[] bookGroups = new int[5];
        for (int i = 0; i <= list.length - 1; i++) {
            if (list[i] == "book1") {
                bookGroups[0]++;
            } else if (list[i] == "book2") {
                bookGroups[1]++;
            } else if (list[i] == "book3") {
                bookGroups[2]++;
            } else if (list[i] == "book4") {
                bookGroups[3]++;
            } else if (list[i] == "book5") {
                bookGroups[4]++;
            }
        }
        return bookGroups;
    }

}
