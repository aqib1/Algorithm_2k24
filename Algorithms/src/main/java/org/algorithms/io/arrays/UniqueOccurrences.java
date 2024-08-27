package org.algorithms.io.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class UniqueOccurrences {
    public static void main(String[] args) {
        System.out.println(
                uniqueOccurrences(
                        new int[]{
                                1, 2, 3
                        }
                )
        );
    }

    // Time complexity O(N) and space complexity O(N)
    public static boolean uniqueOccurrences(int[] arr) {
        if (arr.length == 0) return false;
        var numberCount = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        var uniqueCount = new HashSet<Long>();

        for (int a : numberCount.keySet()) {
            if (uniqueCount.contains(numberCount.get(a)))
                return false;
            else uniqueCount.add(numberCount.get(a));
        }

        return true;
    }
}
