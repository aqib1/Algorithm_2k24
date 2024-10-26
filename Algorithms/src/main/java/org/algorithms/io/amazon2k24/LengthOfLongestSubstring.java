package org.algorithms.io.amazon2k24;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(
                "dvdf"

                // 2
        ));
    }
    public static int lengthOfLongestSubstring(String s) {
        int[] charCount = new int[256];
        int limit = s.length();
        char[] data = s.toCharArray();
        int i = 0, j = 0;
        int maxLen = 0;
        while(i < limit && j < limit) {
            if(charCount[data[j]] < 1) {
                charCount[data[j]]++;
                maxLen = Math.max(maxLen, (j - i) + 1);
                j++;
            } else {
                charCount[data[i++]]--;
            }
        }

        return maxLen;
    }
}
