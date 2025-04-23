package org.algorithms.io.interviewPrep2k25.arrays;

import java.util.ArrayList;
import java.util.List;

public class CreateSubArray {
    public static void main(String[] args) {
        System.out.println(
                subArrayWithoutBuiltin(List.of(1, 2, 3, 4, 5, 6), 3)
        );
    }

    // Time complexity O(n) & space O(n)
    public static List<Integer> subArray(List<Integer> data, int n) {
        if(n <= 0) {
            return new ArrayList<>();
        }

        if(n >= data.size()) {
            return data;
        }

        return data.subList(0, n);
    }

    // Time complexity O(n) & space O(n)
    public static List<Integer> subArrayWithoutBuiltin(List<Integer> data, int n) {
        if(n <= 0) {
            return new ArrayList<>();
        }

        if(n >= data.size()) {
            return data;
        }

        var subArray = new ArrayList<Integer>();

        for(int i = 0; i < n; i++) {
            subArray.add(data.get(i));
        }

        return subArray;
    }
}
