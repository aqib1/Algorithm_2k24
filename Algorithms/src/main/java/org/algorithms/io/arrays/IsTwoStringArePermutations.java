package org.algorithms.io.amazon2k24;

import java.util.HashMap;
import java.util.Map;

public class IsTwoStringArePermutations {

    public static void main(String[] args) {

    }

    // abc => bck
    // [a=1, b=1, c=1] -> [a=1, b=0, c=0]

    public static boolean isPermutation(String s1, String s2) {
        // write your logic here
        if(s1.length() != s2.length())
            return false;
        Map<Character, Integer> charCount = new HashMap<>();
        // [a=1]
        for(char s1Char: s1.toCharArray()) {
//            charCount.put(s1Char, charCount.getOrDefault(s1Char, 0) + 1);
            if(!charCount.containsKey(s1Char)) {
                charCount.put(s1Char, 1);
            } else {
                charCount.put(s1Char, charCount.get(s1Char) + 1);
            }
        }
        // [a=1, b=1, c=1]
        // abc, bba
        for(char s2Char: s2.toCharArray()) {
            if(!charCount.containsKey(s2Char)) {
                return false;
            }
            charCount.put(s2Char, charCount.get(s2Char) - 1);
        }

        for(char key: charCount.keySet()) {
            if(charCount.get(key) != 0) {
                return false;
            }
        }


        return true;
    }
}
