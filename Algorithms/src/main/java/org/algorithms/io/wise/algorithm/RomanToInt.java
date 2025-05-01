package org.algorithms.io.wise.algorithm;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    private static final Map<String, Integer> ROMAN_MAP = new HashMap<>();

    static {
        ROMAN_MAP.put("I", 1);
        ROMAN_MAP.put("V", 5);
        ROMAN_MAP.put("X", 10);
        ROMAN_MAP.put("IV", 4);
        ROMAN_MAP.put("IX", 9);
        ROMAN_MAP.put("L", 50);
        ROMAN_MAP.put("C", 100);
        ROMAN_MAP.put("XL", 40);
        ROMAN_MAP.put("XC", 90);
        ROMAN_MAP.put("D", 500);
        ROMAN_MAP.put("M", 1000);
        ROMAN_MAP.put("CD", 400);
        ROMAN_MAP.put("CM", 900);
    }

    // Time complexity O(n) and space O(1)
    public int romanToInt(String s) {
        int number = 0;
        int i = 0;
        while(i < s.length()) {
            String key;
            if(i + 1 < s.length()) {
                 key = s.substring(i, i + 2);
                if(ROMAN_MAP.containsKey(key)) {
                    i += 2;
                    number += ROMAN_MAP.get(key);
                    continue;
                }
            }
            key = s.substring(i, i + 1);
            number += ROMAN_MAP.get(key);
            i++;
        }
        return number;
    }
}
