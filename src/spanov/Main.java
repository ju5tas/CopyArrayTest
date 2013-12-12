package spanov;

import static spanov.ArrayGroupSort.Order;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 0, 3, 2, 6, 5, 1, 8, 4, 8, 5, 2, 0, 5, 3, 2, 3, 5, 6, 5, 1, 8, 4, 1, 7, 2, 5, 2, 1, 9, 0, 1, 5, 7, 8, 4};
        ArrayGroupSort arrayGroupSort = new ArrayGroupSort(array, 2, 18);

        arrayGroupSort.print()
                .sort().print()
                .orderBy(Order.DESC).sort().print()
                .fillRandom()
                .setProperties(3, 12).print()
                .sort().print()
                .orderBy(Order.ASC).sort().print();
    }
}
