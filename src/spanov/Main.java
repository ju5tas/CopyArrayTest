package spanov;

import static spanov.ArrayGroupSort.Order;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 0, 3, 2, 6, 5,
                1, 8, 4, 8, 5, 2,
                0, 5, 3, 2, 3, 5,
                6, 5, 1, 8, 4, 1,
                7, 2, 5, 2, 1, 9,
                0, 1, 5, 7, 8, 4};

        ArrayGroupSort arrayGroupSort = new ArrayGroupSort(array, 2, 18);

        System.out.println("2x18:");
        arrayGroupSort.print();
        arrayGroupSort.sort().print();
        arrayGroupSort.orderBy(Order.DESC).sort().print();

        System.out.println("3x13:");
        arrayGroupSort.fillRandom().setGroupProperties(3, 12).print();
        arrayGroupSort.sort().print();
        arrayGroupSort.orderBy(Order.ASC).sort().print();


        System.out.println("1x36:");
        arrayGroupSort.setGroupProperties(1, 36).print();
        arrayGroupSort.sort().print();
        arrayGroupSort.orderBy(Order.DESC).sort().print();
    }
}
