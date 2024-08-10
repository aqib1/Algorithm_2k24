package org.algorithms.io.strings;

public class MaxVowelsSlidingWindow {
    public static void main(String[] args) {
        var maxVowels = new MaxVowelsSlidingWindow();
        System.out.println(
                maxVowels.maxVowels(
                        "leetcode",
                        2
                )
        );
    }

    // Time complexity O(N)
    // Space complexity is O(1)
    public int maxVowels(String s, int k) {
        char[] data = s.toCharArray();
        int start = 0, end = 0;
        int countVowel = 0;
        int maxVowels = Integer.MIN_VALUE;
        while (end < data.length) {
            if(isVowel(data[end])) {
                countVowel++;
            }
            if ((end - start) + 1 == k) {
                maxVowels = Math.max(maxVowels, countVowel);
                if(isVowel(data[start]))
                    countVowel--;
                start++;
            }

            end++;
        }

        return maxVowels;
    }

    public boolean isVowel(char c) {
        return c == 'a' ||
                c == 'e' ||
                c == 'i' ||
                c == 'o' ||
                c == 'u';
    }
}
