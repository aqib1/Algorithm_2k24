package org.algorithms.io.amazon2k24;

import java.util.HashMap;
import java.util.HashSet;

public class MaxFrequency {
    public static void main(String[] args) {
        System.out.println(maxFreq("aaaa", 1, 3, 3));
    }

    // Time complexity O(N * M) where M is substring in case is N == M then O(n)2
    // Space complexity O(N * M) where M is substring, in case of N == M then O(n)2
    public static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int max = 0;
        var subStringCount = new HashMap<String, Integer>();

        for(int i = 0; i <= s.length() - minSize; i++) {
            var substr = s.substring(i, i + minSize);
            if(isValid(substr, maxLetters)) {
                subStringCount.put(substr, subStringCount.getOrDefault(substr, 0) + 1);
            }
        }

        for(var key: subStringCount.keySet()) {
            var value = subStringCount.get(key);
            if(max < value) {
                max = value;
            }
        }

        return max;
    }

    private static boolean isValid(String substr, int maxLetters) {
        var set = new HashSet<Character>();
        for(char c: substr.toCharArray()) {
            set.add(c);
        }

        return set.size() <= maxLetters;
    }
}
