package org.algorithms.io.trie;

import java.util.*;

public class AutocompleteSystem {
    static class Trie {
        private static final int LIMIT = 256;
        private final Trie[] nodes;
        private final Map<String, Integer> sentenceCount;
        private int end;
        private int count;
        public Trie() {
            this.nodes = new Trie[LIMIT];
            this.sentenceCount = new HashMap<>();
        }

        public void insert(String word, int count) {
            var current = this;
            for(char ch: word.toCharArray()) {
                if(current.nodes[ch] == null) {
                    current.nodes[ch] = new Trie();
                }
                current = current.nodes[ch];
                current.sentenceCount.put(word, current.sentenceCount.getOrDefault(word, 0) + count);
            }
            current.end++;
        }
    }

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
