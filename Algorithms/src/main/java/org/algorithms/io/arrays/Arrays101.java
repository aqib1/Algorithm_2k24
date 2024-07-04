package org.algorithms.io.arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Arrays101 {

    public static void main(String[] args) {
        int[] data = {22, 12, 8, 10, 9, 23};

        System.out.println(findElement(data, 10));
        System.out.println(findElement(data, -12));


        data = deleteElement(data, 8);
        System.out.println(Arrays.toString(data));

        data = deleteElement(data, 23);
        System.out.println(Arrays.toString(data));

        data = deleteElement(data, 22);
        System.out.println(Arrays.toString(data));
    }

    // Space complexity = O(1)
    // Time complexity = O(n)
    private static boolean findElement(int[] data, int target) {
        return Arrays.stream(data)
                .anyMatch(i -> i == target);
    }


    // Space complexity = O(n)
    // Time complexity = O(n)
    private static int[] deleteElement(
            int[] data,
            int target
    ) {
        int indexFound =
                IntStream.range(0, data.length)
                        .filter(index -> data[index] == target)
                        .findFirst()
                        .orElse(-1);

        if (indexFound == -1) {
            throw new IllegalArgumentException();
        }

        int [] updatedArray = new int [data.length - 1];
        IntStream.range(0, indexFound)
                .forEach(index -> updatedArray[index] = data[index]);

        for(int i = indexFound; i < data.length - 1; i++) {
            updatedArray[i] = data[i + 1];
        }

        return updatedArray;
    }
}
