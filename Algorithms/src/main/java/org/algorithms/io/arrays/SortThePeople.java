package org.algorithms.io.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

public class SortThePeople {

    public static void main(String[] args) {
        var sortThePeople = new SortThePeople();

        System.out.println(
                Arrays.toString(
                        sortThePeople.sortPeople(
                                new String[] {"Mary","John","Emma"},
                                new int[] {180,165,170}
                        )
                )
        );
    }

    public String[] sortPeople(String[] names, int[] heights) {
        var heightByPeople = new HashMap<Integer, String>();
        var result = new String[names.length];
        for(int i = 0; i < heights.length; i++) {
            heightByPeople.put(heights[i], names[i]);
        }
        selectionSort(heights);
        IntStream.range(0, heights.length)
                .forEach(i -> result[i] = heightByPeople.get(heights[i]));
        return result;
    }

    private void selectionSort(int[] heights) {
        int start = 0;
        while(start < heights.length) {
            int smallest = Integer.MIN_VALUE;
            int smallestValueIndex = start;
            for (int i = start; i < heights.length; i++) {
                if (heights[i] >= smallest) {
                    smallest = heights[i];
                    smallestValueIndex = i;
                }
            }
            replace(heights, start, smallestValueIndex);
            start++;
        }
    }

    private void replace(int[] heights, int start, int smallestValueIndex) {
        var first = heights[start];
        heights[start] = heights[smallestValueIndex];
        heights[smallestValueIndex] = first;
    }
}
