package org.algorithms.io.map;

import java.util.*;

/*
 * Input: s = "barfoothefoobarman", words = ["foo","bar"]
 * Output: [0,9]
 * Explanation:
 * The substring starting at 0 is "barfoo".
 * It is the concatenation of ["bar","foo"] which is a permutation of words.
 * The substring starting at 9 is "foobar".
 * It is the concatenation of ["foo","bar"] which is a permutation of words.
 * */

public class ConcatOfAllWords {
    public static void main(String[] args) {
        System.out.println(findSubstring("barfoothefoobarman", new String[]{"bar","foo"}));
    }

    // Time complexity O(n * w) where n is character in s and w is words lenghth
    // Space complexity O(n * w)
    public static List<Integer> findSubstring(String s, String[] words) {
        var response = new ArrayList<Integer>();
        if (s.isEmpty() || words.length == 0)
            return response;
        var wordsCount = new HashMap<String, Integer>();
        var wordLen = words[0].length();
        var wordsLen = wordLen * words.length;

        for (String word : words) {
            wordsCount.put(word, wordsCount.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i + wordsLen <= s.length(); i++) {
            var subStr = s.substring(i, i + wordsLen);
            if (checkPermutations(
                    subStr,
                    wordLen,
                    wordsCount
            )) {
                response.add(i);
            }
        }

        return response;
    }

    private static boolean checkPermutations(String subStr, int wordLen, HashMap<String, Integer> wordsCount) {
        var subStrWordCount = new HashMap<String, Integer>();
        for (int i = 0; i < subStr.length(); i += wordLen) {
            var subStrWord = subStr.substring(i, i + wordLen);
            subStrWordCount.put(
                    subStrWord,
                    subStrWordCount.getOrDefault(subStrWord, 0) + 1
            );
        }
        return wordsCount.equals(subStrWordCount);
    }
}
