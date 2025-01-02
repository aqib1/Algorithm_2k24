package org.algorithms.io.arrays;


public class MinSwapsII {
    public static void main(String[] args) {
        var min = new MinSwapsII();
        System.out.println(
                min.minSwaps(
                        new int[]{0,1,0,1,1,0,0}
                )
        );
    }

    // Time complexity O(n)
    // Space complexity O(2*n)
    public int minSwaps(int[] nums) {
        int windowSize = 0;
        for (int i : nums) windowSize += i;

        var appendArray = new int[nums.length * 2];
        System.arraycopy(
                nums,
                0,
                appendArray,
                0,
                nums.length
        );

        System.arraycopy(
                nums,
                0,
                appendArray,
                nums.length,
                nums.length
        );

        int onesInCurrentWindow = 0;
        int maxOnesInWindow = Integer.MIN_VALUE;

        for(int i = 0; i < appendArray.length; i++) {
            onesInCurrentWindow += appendArray[i];
            if(i >= windowSize) {
                onesInCurrentWindow -= appendArray[i - windowSize];
            }
            maxOnesInWindow = Math.max(maxOnesInWindow, onesInCurrentWindow);
        }

        return windowSize - maxOnesInWindow;
    }
}
