package org.algorithms.io.strings;

import java.util.HashMap;
import java.util.Objects;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window
 * substring
 * of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 * The testcases will be generated such that the answer is unique.
 * Example 1:
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 */
public class MinWindow76 {
    public static void main(String[] args) {
        var min = new MinWindow76();
        System.out.println(
                min.minWindow("ADOBECODEBANC", "ABC")
        );
    }

    // Time complexity O(n * m)
    // Space O(n + m)
    public String minWindow(String s, String t) {
        if(t.length() > s.length())
            return "";
        if(s.length() == 1 && s.equals(t))
            return s;

        var templateCount = new HashMap<Character, Integer>();
        var stringCount = new HashMap<Character, Integer>();
        int minLen = Integer.MAX_VALUE;
        var response = "";
        // O(m) where m is number of template character
        // O(m) space
        for (char ch : t.toCharArray())
            templateCount.put(ch, templateCount.getOrDefault(ch, 0) + 1);

        int start = 0, end = 0;
        // O(n) where n is number of character in string
        while (start < s.length() && end <= s.length()) {
            // O(m) time complexity where m number of character in template
            if(allCharacterFound(stringCount, templateCount)) {
                int len = (end - start);
                if (minLen > len) {
                    minLen = len;
                    response = s.substring(start, end);
                }
                if (templateCount.containsKey(s.charAt(start))) {
                    stringCount.put(
                            s.charAt(start),
                            stringCount.get(s.charAt(start)) - 1
                    );
                }
                start++;
            } else {
                if(end < s.length()) {
                    var ch = s.charAt(end);
                    stringCount.put(
                            ch,
                            stringCount.getOrDefault(ch, 0) + 1
                    );
                }
                end++;
            }
        }

        return response;
    }

    private boolean allCharacterFound(HashMap<Character, Integer> stringCount, HashMap<Character, Integer> templateCount) {
        for (var tmpKey : templateCount.keySet()) {
            if (!stringCount.containsKey(tmpKey) ||
                    stringCount.get(tmpKey) < templateCount.get(tmpKey)) {
                return false;
            }
        }

        return true;
    }
}
