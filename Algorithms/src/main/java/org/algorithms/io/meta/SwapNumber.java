package org.algorithms.io.meta;


public class SwapNumber {
    public static void main(String[] args) {
        System.out.println(maximumSwap(120));
    }
    /**
     * You are given an integer num. You can swap two digits at most once to get the maximum valued number.
     * Return the maximum valued number you can get.
     * Example 1:
     * Input: num = 2736
     * Output: 7236
     * Explanation: Swap the number 2 and the number 7.
     * Example 2:
     * Input: num = 9973
     * Output: 9973
     * Explanation: No swap.
     * */
    // Time complexity O(n) and space O(n)
    public static int maximumSwap(int num) {
        var numStr = String.valueOf(num).toCharArray();
        var maxFromRight = new int[numStr.length];
        maxFromRight[maxFromRight.length - 1] = numStr.length - 1;
        for(var right = maxFromRight.length - 2; right >= 0; right--) {
            if(numStr[right] - 'a' <= numStr[maxFromRight[right + 1]] - 'a') {
                maxFromRight[right] = maxFromRight[right + 1];
            } else {
                maxFromRight[right] = right;
            }
        }

        for(var i = 0; i < numStr.length; i++) {
            if(numStr[i] < numStr[maxFromRight[i]]) {
                var tmp = numStr[i];
                numStr[i] = numStr[maxFromRight[i]];
                numStr[maxFromRight[i]] = tmp;
                break;
            }
        }

        return Integer.parseInt(new String(numStr));
    }
}
