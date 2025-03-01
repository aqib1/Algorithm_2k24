package org.algorithms.io.google;

public class MergeAlternative {
    // Time complexity O(n + m) ~= O(n)
    // Space complexity O(n + m) ~= O(n)
    public String mergeAlternately(String word1, String word2) {
        var merged = new char[word1.length() + word2.length()];
        int mergeIndex = 0, w1 = 0, w2 = 0;
        while(w1 < word1.length() && w2 < word2.length()) {
            merged[mergeIndex++] = word1.charAt(w1++);
            merged[mergeIndex++] = word2.charAt(w2++);
        }

        while(w1 < word1.length()) {
            merged[mergeIndex++] = word1.charAt(w1++);
        }

        while(w2 < word2.length()) {
            merged[mergeIndex++] = word2.charAt(w2++);
        }

        return new String(merged);
    }
}
