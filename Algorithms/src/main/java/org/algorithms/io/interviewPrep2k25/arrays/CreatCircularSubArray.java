package org.algorithms.io.interviewPrep2k25.arrays;

import java.util.ArrayList;
import java.util.List;

public class CreatCircularSubArray {
    public static void main(String[] args) {
        System.out.println(
                subArrayCircular(List.of(1, 2, 3), 12)
        );
    }

    // Time complexity O(n) & space O(n)
    public static List<Integer> subArrayCircular(List<Integer> data, int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        var subArray = new ArrayList<Integer>();
        int index = 0;
        while (n > 0) {
            if (index % data.size() == 0) {
                index = 0;
            }
            subArray.add(data.get(index));
            index++;
            n--;
        }

        return subArray;
    }
}
