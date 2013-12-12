package spanov;

public class ArrayGroupSort {

    public static enum Order {
        DESC(1), ASC(-1);

        private int value;

        public int getValue() {
            return value;
        }

        Order(int i) {
            value = i;
        }
    }

    private int groupLength;
    private int groupsCount;
    private Order order = Order.ASC;


    private int[] array;
    private int[] tmpArray;
    private boolean isPrintProcess = false;

    public ArrayGroupSort() {
        this(2, 10);
    }

    public ArrayGroupSort setProperties(int groupLength, int groupsCount) {
        if (groupLength * groupsCount != array.length) throw new RuntimeException("setProperties(): wrong parameters.");
        init(groupLength, groupsCount);
        return this;
    }

    private void init(int groupLength, int groupsCount) {
        this.groupsCount = groupsCount;
        this.groupLength = groupLength;
        tmpArray = new int[this.groupLength];
    }

    public ArrayGroupSort orderBy(Order order) {
        this.order = order;
        return this;
    }

    public ArrayGroupSort(int groupLength, int groupsCount) {
        init(groupLength, groupsCount);
        array = new int[groupLength * groupsCount];
    }

    public ArrayGroupSort(int[] arr, int groupLength, int groupsCount) {
        init(groupLength, groupsCount);
        array = arr;
    }

    private void printIndicated(int s1, int s2) {
        for (int i = 0; i < groupsCount; i++) {
            System.out.print(i == s1 || i == s2 ? "(" : " ");
            for (int j = 0; j < groupLength; j++) {
                System.out.print(getElementInGroup(i, j));
            }
            System.out.print(i == s2 || i == s1 ? ")" : " ");
        }
        System.out.println();
    }

    public ArrayGroupSort fillRandom() {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10);
        }
        return this;
    }

    private int compare(int s1, int s2) {
        for (int i = 0; i < groupLength; i++) {
            if (getElementInGroup(s1, i) == getElementInGroup(s2, i)) continue;
            return getElementInGroup(s1, i) - getElementInGroup(s2, i);
        }
        return 0;
    }

    private int getElementInGroup(int groupId, int elementId) {
        return array[getElementIdByGroup(groupId, elementId)];
    }

    private int getElementIdByGroup(int groupId, int elementId) {
        if (groupId > groupsCount) throw new IndexOutOfBoundsException("Group id must be between 0 and" + groupsCount);
        return groupId * groupLength + elementId;
    }

    private void swap(int s1, int s2) {
        if (s1 > groupsCount || s2 > groupsCount)
            throw new IndexOutOfBoundsException("Group id must be between 0 and" + groupsCount);
        System.arraycopy(array, getElementIdByGroup(s1, 0), tmpArray, 0, groupLength);
        System.arraycopy(array, getElementIdByGroup(s2, 0), array, getElementIdByGroup(s1, 0), groupLength);
        System.arraycopy(tmpArray, 0, array, getElementIdByGroup(s2, 0), groupLength);
        if (isPrintProcess) printIndicated(s1, s2);
    }

    public ArrayGroupSort sort() {
        int n = groupsCount;
        int newn;
        do {
            newn = 0;
            for (int i = 1; i < n; i++) {
                if (order.getValue() * compare(i - 1, i) > 0) {
                    swap(i - 1, i);
                    newn = i;
                }
            }
            n = newn;
        } while (n > 0);
        return this;
    }

    private void printGroup(int i) {
        System.out.print("[");
        for (int j = 0; j < groupLength; j++) {
            System.out.print(getElementInGroup(i, j));
        }
        System.out.print("]");
    }

    public ArrayGroupSort print() {
        for (int i = 0; i < groupsCount; i++) {
            printGroup(i);
        }
        System.out.println();
        return this;
    }

    public ArrayGroupSort setPrintProcess(boolean printProcess) {
        isPrintProcess = printProcess;
        return this;
    }
}
