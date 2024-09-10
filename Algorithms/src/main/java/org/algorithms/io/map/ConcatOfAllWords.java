package org.algorithms.io.map;

import java.util.*;
import java.util.stream.Collectors;

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
        System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"}));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        var joinWords = String.join("", words);
        var wordsLength = joinWords.length();
        var response = new ArrayList<Integer>();
        if (s.length() < wordsLength || wordsLength == 0)
            return List.of();

        var eachWordLen = words[0].length();
        var wordsCount = Arrays.stream(words)
                .collect(
                        Collectors.toMap(
                                k -> k,
                                v -> 1,
                                Integer::sum
                        )
                );


        for(int i = 0; i + wordsLength <= s.length(); i++) {
            if(checkPermutationOfWords(i, eachWordLen, wordsLength, s, wordsCount)) {
                response.add(i);
            }
        }

        return response;
    }

    private static boolean checkPermutationOfWords(int start, int eachWordLen, int wordsLength, String s, Map<String, Integer> wordsCount) {
        var wordsKey = wordsCount.keySet();
        var strWordCount = new HashMap<String, Integer>();

        for(int i = start; i <= (start + wordsLength) - eachWordLen; i+= eachWordLen) {
            var subStr  = s.substring(i, i + eachWordLen);
            if(!wordsKey.contains(subStr)) {
                return false;
            }

            if(strWordCount.containsKey(subStr)) {
                strWordCount.put(subStr, strWordCount.get(subStr) + 1);
            } else {
                strWordCount.put(subStr, 1);
            }
        }

        for(var key: wordsCount.keySet()) {
            if(!Objects.equals(strWordCount.get(key), wordsCount.get(key))) {
                return false;
            }
        }

        return true;
    }
}
