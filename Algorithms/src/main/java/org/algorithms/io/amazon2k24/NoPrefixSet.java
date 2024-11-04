package org.algorithms.io.amazon2k24;

import java.util.List;

public class NoPrefixSet {

    public static void main(String[] args) {
        noPrefix(List.of(
                "aab",
                "defgab",
                "abcde",
                "aabcde",
                "bbbbbbbbbb",
                "jabjjjad"
        ));
    }

    // Space complexity is O(N * L)
    public static void noPrefix(List<String> words) {
        Trie trie = new Trie();
        for (String word : words) {
            if (!trie.insert(word)) {
                System.out.println("BAD SET");
                System.out.println(word);
                return;
            }
        }
        System.out.println("GOOD SET");
    }

    static class Trie {
        private static final int LIMIT = 26;
        private boolean end;
        private final Trie[] nodes;

        public Trie() {
            this.nodes = new Trie[LIMIT];
        }

        // O(N) where N is no of characters.
        public boolean insert(String word) {
            var current = this;
            var inserted = false;
            for(char c: word.toCharArray()) {
                int idx = c - 'a';
                if(current.nodes[idx] == null) {
                    current.nodes[idx] = new Trie();
                    inserted = true;
                }
                current = current.nodes[idx];
                if(current.end) {
                    break;
                }
            }
            current.end = true;
            return inserted;
        }
    }
}
