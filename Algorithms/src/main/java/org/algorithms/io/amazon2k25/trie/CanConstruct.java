package org.algorithms.io.amazon2k25.trie;


public class CanConstruct {
    // Time complexity O(n) and space O(26)
    public boolean canConstruct(String ransomNote, String magazine) {
        var count = new int[26];
        for(var m: magazine.toCharArray()) {
            count[m - 'a']++;
        }
        for(var r: ransomNote.toCharArray()) {
            if(--count[r - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var can = new CanConstruct();
        System.out.println(can.canConstruct("aa", "aab"));
    }
}
