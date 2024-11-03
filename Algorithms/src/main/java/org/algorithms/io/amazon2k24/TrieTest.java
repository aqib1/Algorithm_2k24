package org.algorithms.io.amazon2k24;

public class TrieTest {
    // O(N) space and memory where N is number of characters
    class Trie {
        private static final int BRANCH_LIMIT = 26;
        private Trie[] branches;
        private int count;
        private boolean isComplete;
        public Trie() {
            this.branches = new Trie[BRANCH_LIMIT];
        }

        public void insert(String word) {
            Trie current = this;
            for(char c: word.toCharArray()) {
                int idx = c - 'a';
                if(current.branches[idx] == null) {
                    current.branches[idx] = new Trie();
                }
                current = current.branches[idx];
                current.count++;
            }

            current.isComplete= true;
        }

        public boolean search(String word) {
            Trie current = this;
            for(char c: word.toCharArray()) {
                int idx = c - 'a';
                if(current.branches[idx] == null)
                    return false;
                current = current.branches[idx];
            }

            return current.isComplete;
        }

        public boolean startsWith(String prefix) {
            Trie current = this;
            for(char c: prefix.toCharArray()) {
                int idx = c - 'a';
                if(current.branches[idx] == null)
                    return false;
                current = current.branches[idx];
            }
            return true;
        }
    }
}
