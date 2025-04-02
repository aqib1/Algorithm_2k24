package org.algorithms.io.interviewPrep2k25;

import java.util.Arrays;
import java.util.function.BiPredicate;

public class InsertionSortDynamic {
    private BiPredicate<Integer, Integer> test;

    public static void main(String[] args) {
        var insertion = new InsertionSortDynamic();
        BiPredicate<Integer, Integer> test = (a, b) -> a < b;
        var data = new int[] {3, 1, -2, 8, -6, 2, 188};
        insertion.insertionSort(data, test);
        System.out.println(Arrays.toString(data));
    }
    public void insertionSort(int[] data, BiPredicate<Integer, Integer> test) {
        for(int i = 1; i < data.length; i++) {
            int ptrData = data[i];
            int ptr = i;
            while(ptr > 0 && test.test(data[ptr - 1], ptrData)) {
                data[ptr] = data[ptr - 1];
                ptr--;
            }
            data[ptr] = ptrData;
        }
    }
}
