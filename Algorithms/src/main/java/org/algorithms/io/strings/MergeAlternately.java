package org.algorithms.io.strings;

/**
 * 1768. Merge Strings Alternately
 * <p>
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
 * <p>
 * Return the merged string.
 * <p>
 */
public class MergeAlternately {


    // Time complexity O(N+M), if (N = M) then O2(N) = O(N) as 2 is constant
    // Space complexity O(N+M), if (N = M) then O2(N) = O(N) as 2 is constant
    public String mergeAlternately(String word1, String word2) {
        var builder = new StringBuilder();
        int len1 = word1.length();
        int len2 = word2.length();
        int limit = Math.min(len1, len2);

        for (int x = 0; x < limit; x++) {
            builder.append(word1.charAt(x)).append(word2.charAt(x));
        }


        return (len1 > len2) ? builder.append(word1.substring(limit)).toString() :
                builder.append(word2.substring(limit)).toString();
    }
}
