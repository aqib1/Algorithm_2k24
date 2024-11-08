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
    }
}
