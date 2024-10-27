package org.algorithms.io.amazon2k24;

import java.util.Arrays;
import java.util.Objects;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(
                longestCommonPrefix(new String[] {"ab", "a"})
        );
    }

    // Time ON(LogN), space O(1)
    public static String longestCommonPrefix(String[] strs) {
        if(Objects.isNull(strs) || strs.length == 0)
            return "";
        if(strs.length == 1) return strs[0];

        Arrays.sort(strs);

        int matchCount = 0;
        while(strs[0].length() > matchCount && strs[0].charAt(matchCount) == strs[strs.length - 1].charAt(matchCount))
            matchCount++;

        return strs[strs.length - 1].substring(0, matchCount);
    }
}
