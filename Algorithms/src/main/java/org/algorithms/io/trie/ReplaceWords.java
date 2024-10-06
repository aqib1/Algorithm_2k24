package org.algorithms.io.trie;

import java.util.List;

public class ReplaceWords {
    static class Trie {
        private static final int LIMIT = 26;
        private final Trie[] nodes;
        private int count;
        private int end;
        public Trie() {
            this.nodes = new Trie[LIMIT];
        }

        public void insert(String word) {
            var current = this;
            for(char ch: word.toCharArray()) {
                int idx = ch - 'a';
                if(current.nodes[idx] == null) {
                    current.nodes[idx] = new Trie();
                }
                current = current.nodes[idx];
                current.count++;
            }
            current.end++;
        }
    }
    public String replaceWords(List<String> dictionary, String sentence) {

        return "";
    }
}
