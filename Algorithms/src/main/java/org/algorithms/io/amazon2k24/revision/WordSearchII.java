package org.algorithms.io.amazon2k24.revision;

public class WordSearchII {
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

        public boolean containKey(char key) {
            int idx = key - 'a';
            return this.nodes[idx] != null;
        }
    }
}
