package org.algorithms.io.strings;


public class LongestCommonSubsequence {
    public static void main(String[] args) {
        var lcs = new LongestCommonSubsequence();
        System.out.println(
           lcs.longestCommonSubsequence(
                   "abcde",
                   "abc"
           )
        );
    }
    // Time complexity O(m * n)
    // Space complexity due to memoization O(m * n)
    public int longestCommonSubsequence(String text1, String text2) {
        return lcs(
                text1,
                text2,
                text1.length(),
                text2.length(),
                new Integer[text1.length() + 1][text2.length() + 1]
        );
    }

    private int lcs(
            String text1,
            String text2,
            int n,
            int m,
            Integer[][] memo
    ) {
        if (n == 0 || m == 0)
            return 0;
        if (memo[n][m] != null)
            return memo[n][m];

        if (text1.charAt(n - 1) == text2.charAt(m - 1)) {
            return memo[n][m] =
                    1 + lcs(text1, text2, n - 1, m - 1, memo);
        } else {
            return memo[n][m] = Math.max(
                    lcs(text1, text2, n - 1, m, memo),
                    lcs(text1, text2, n, m - 1, memo)
            );
        }
    }
}
