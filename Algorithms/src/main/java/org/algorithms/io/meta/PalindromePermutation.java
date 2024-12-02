package org.algorithms.io.meta;

import java.util.HashMap;

public class PalindromePermutation {
    public static void main(String[] args) {
        var pal = new PalindromePermutation();
        System.out.println(
                pal.canPermutePalindrome("as")
        );
    }
    public boolean canPermutePalindrome(String s) {
        boolean isEven = s.length() % 2 == 0;
        var countMap = new HashMap<Character, Integer>();
        for(char ch: s.toCharArray()) {
            countMap.put(
                    ch,
                    countMap.getOrDefault(ch, 0) + 1
            );
        }

        int evenCount = 0;
        int oddCount = 0;
        var keySet = countMap.keySet();
        for(var key: keySet) {
            if(countMap.get(key) % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        return isEven ? evenCount == keySet.size() : oddCount == 1;
    }

    // aacccbbbbb ->
    // accbb
    //dbcacbd
}
