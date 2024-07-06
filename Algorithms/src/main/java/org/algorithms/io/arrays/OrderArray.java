package org.algorithms.io.arrays;


import java.util.function.BiPredicate;
import java.util.stream.IntStream;

public class OrderArray {
    private final long[] orderedData;
    private int elementLimit = 0;
    private BiPredicate<Long, Long> comparator = (a, b) -> a > b;

    public OrderArray(int size) {
        orderedData = new long[size];
    }

    public OrderArray(int size, BiPredicate<Long, Long> comparator) {
        this(size);
        this.comparator = comparator;
    }

    // we will find using binary search
    // time complexity long(n) where n is the size of array
    public int find(long searchValue) {
        int start = 0;
        int end = elementLimit;
        int current = (start + end) / 2;
        while (start <= end) {
            if (orderedData[current] == searchValue) {
                return current;
            }

            if (comparator.test(searchValue, orderedData[current])) {
                start = current + 1;
            } else {
                end = current - 1;
            }
            current = (start + end) / 2;
        }

        return -1;
    }

    public void insert(
            long value
    ) {
        if (elementLimit >= orderedData.length) {
            throw new IllegalArgumentException("We can not add more element");
        }
        // find where number need to fit
        int foundInsertIndex = 0;
        for (; foundInsertIndex < elementLimit; foundInsertIndex++) {
            if (comparator.test(orderedData[foundInsertIndex], value)) {
                break;
            }
        }

        // move rest of number ahead
        for (int i = elementLimit; i > foundInsertIndex; i--) {
            orderedData[i] = orderedData[i - 1];
        }

        orderedData[foundInsertIndex] = value;
        elementLimit++;
    }

    public boolean delete(long value) {
        int found = find(value);
        if(found == -1) {
            return false;
        }

        for(int i = found; i <= elementLimit; i++) {
            orderedData[i] = orderedData[i + 1];
        }

        elementLimit--;
        return true;
    }

    public void display() {
        IntStream.range(0, elementLimit)
                .forEach(i -> System.out.print(orderedData[i] + " "));

        System.out.println();
    }

    public int size() {
        return elementLimit;
    }

    public static void main(String[] args) {
        var orderArray = new OrderArray(
                10,
                (a, b) -> b > a
        );
        orderArray.insert(2);
        orderArray.insert(1);
        orderArray.insert(10);
        orderArray.insert(6);
        orderArray.insert(3);
        orderArray.insert(0);

        orderArray.display();

        System.out.println(orderArray.delete(10));

        orderArray.display();
    }
}
