package org.algorithms.io.recursion;

import java.util.ArrayList;
import java.util.List;

public class Anagram {

    public static void main(String[] args) {
        var anagram = new Anagram();
        System.out.println(
                anagram.anagrams("abc")
        );
    }

    public List<String> anagrams(String word) {
        var anagrams = new ArrayList<String>();
        findAnagrams(word, "", anagrams);
        return anagrams;
    }

    // Time complexity O(n!) with space O(n * n!)
    public void findAnagrams(String str, String prefix, List<String> anagrams) {
        if(str.isEmpty()) {
            anagrams.add(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                char current = str.charAt(i);
                String remaining = str.substring(0, i) + str.substring(i + 1);
                findAnagrams(remaining, prefix + current, anagrams);
            }
        }
    }
}
