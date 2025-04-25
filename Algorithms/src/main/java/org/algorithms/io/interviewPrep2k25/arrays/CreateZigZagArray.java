package org.algorithms.io.interviewPrep2k25.arrays;

import java.util.ArrayList;
import java.util.List;

public class CreateZigZagArray {
    public static void main(String[] args) {
        System.out.println(
                zigZagSubArray(List.of(1, 2, 3), 12)
        );
    }

    // Time complexity O(n) and space O(n)
    public static List<Integer> zigZagSubArray(List<Integer> data, int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }

        var subArray = new ArrayList<Integer>();
        var reverse = false;
        int index = 0;
        while (n > 0) {
            if (index % data.size() == 0) {
                reverse = !reverse;
            }

            if (reverse) {
                subArray.add(data.get(index));
                index++;
            } else {
                index--;
                subArray.add(data.get(index));
            }

            n--;
        }

        return subArray;
    }
}
