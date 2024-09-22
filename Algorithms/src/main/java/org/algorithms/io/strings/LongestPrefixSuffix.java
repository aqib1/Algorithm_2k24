package org.algorithms.io.strings;

import java.util.Arrays;

public class LongestPrefixSuffix {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        lps("abcabcf")
                )
        );
    }

    // Time complexity O(n)
    // Space O(n)
    public static int[] lps(String pattern) {
        if (pattern == null || pattern.isBlank())
            return new int[]{};
        char[] chars = pattern.toCharArray();
        int[] lps = new int[pattern.length()];
        lps[0] = 0;
        int len = 0;
        for(int i = 1; i < lps.length; ) {
            if(chars[len] == chars[i]) {
                lps[i] = ++len;
                i++;
            } else {
                if(len != 0) {
                 len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
