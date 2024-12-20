package org.algorithms.io.strings;


public class LongestCommonSubsequence {
    public static void main(String[] args) {
        var lcs = new LongestCommonSubsequence();
        System.out.println(
           lcs.longestCommonSubsequenceMemoization(
                   "abcde",
                   "abc"
           )
        );
    }

    // time complexity O(n * m)
    // Space complexity O(n * m)
    public int longestCommonSubsequenceDp(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int [][] dp = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j- 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }

    // Time complexity O(m * n)
    // Space complexity due to memoization O(m * n)
    public int longestCommonSubsequenceMemoization(String text1, String text2) {
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
