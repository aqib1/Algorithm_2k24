package org.algorithms.io.interviewPrep2k25.strings;

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

    public static int romanToInt(String s) {
        int number = 0;
        int i = 0;

        while(i < s.length()) {
            if(i + 1 < s.length()) {
                var twoCharKey = s.substring(i, i + 2);
                if(ROMAN_MAP.containsKey(twoCharKey)) {
                    number += ROMAN_MAP.get(twoCharKey);
                    i += 2;
                    continue;
                }
            }
            number += ROMAN_MAP.get(s.substring(i, i + 1));
            i++;
        }
        return number;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
    }
}
