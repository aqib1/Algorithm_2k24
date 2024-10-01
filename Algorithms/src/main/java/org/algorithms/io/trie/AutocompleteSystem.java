package org.algorithms.io.trie;

import java.util.*;

public class AutocompleteSystem {
    public AutocompleteSystem(String[] sentences, int[] times) {

    }

    public List<String> input(char c) {

    }

    public static void main(String[] args) {
        var complete = new AutocompleteSystem(
                new String[] {
                        "i love you",
                        "island",
                        "iroman",
                        "i love leetcode"
                },
                new int[] {5, 3, 2, 2}
        );

        System.out.println(complete.input('i'));
        System.out.println(complete.input(' '));
        System.out.println(complete.input('a'));
        System.out.println(complete.input('#'));
    }
}
