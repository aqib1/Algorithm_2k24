package org.algorithms.io.trie;

public class AutoCompleteSystem {
    static class Trie {
        private static final int LIMIT = 26;
        private final Trie[] nodes;
        private int end;
        private int count;

        public Trie() {
            this.nodes = new Trie[LIMIT];
        }

    }
}
