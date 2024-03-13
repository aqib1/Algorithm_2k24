package org.algorithms.io.meta;

public class SwapNumberSpaceOptimized {
    public static void main(String[] args) {
        System.out.println(maximumSwap(98368));
    }
    // Time complexity O(n) and space O(n) using greedy approach without any extra space
    public static int maximumSwap(int num) {
        // This will take O(n) space due to converting toCharArray
        var numData = String.valueOf(num).toCharArray();
        int maxValueIndex = numData.length - 1;
        int swap1 = -1, swap2 = maxValueIndex;

        for(int i = numData.length - 2; i >= 0; i--) {
            if(numData[i] > numData[maxValueIndex]) {
                maxValueIndex = i;
            } else if(numData[i] < numData[maxValueIndex]) {
                swap1 = i;
                swap2 = maxValueIndex;
            }
        }

        if(swap1 != -1) {
            var tmp = numData[swap1];
            numData[swap1] = numData[swap2];
            numData[swap2] = tmp;
        }

        return Integer.parseInt(new String(numData));
    }
}
