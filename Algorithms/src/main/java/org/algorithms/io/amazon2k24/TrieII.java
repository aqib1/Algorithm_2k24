package org.algorithms.io.amazon2k24;

public class TrieII {
    class Trie {
        private static final int BRANCH_LIMIT = 26;
        private Trie[] branches;
        private int count;
        private int end;

        public Trie() {
            this.branches = new Trie[BRANCH_LIMIT];
        }

        public void insert(String word) {
            Trie current = this;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (current.branches[idx] == null) {
                    current.branches[idx] = new Trie();
                }
                current = current.branches[idx];
                current.count++;
            }
            current.end++;
        }

        public int countWordsEqualTo(String word) {
            Trie current = this;
            for(char c: word.toCharArray()) {
                int idx = c - 'a';
                if(current.branches[idx] == null) {
                    return 0;
                }
                current = current.branches[idx];
            }

            return current.end;
        }

        public int countWordsStartingWith(String prefix) {
            Trie current = this;
            for(char c: prefix.toCharArray()) {
                int idx = c - 'a';
                if(current.branches[idx] == null) {
                    return 0;
                }
                current = current.branches[idx];
            }

            return current.count;
        }

        public void erase(String word) {
            Trie current = this;
            Trie nodeToBeRemoved;
            for(char c: word.toCharArray()) {
                 int idx = c - 'a';
                 nodeToBeRemoved = current.branches[idx];
                 nodeToBeRemoved.count--;
                 if(nodeToBeRemoved.count == 0) {
                     current.branches[idx] = null;
                 }
                 current = nodeToBeRemoved;
            }
            current.end--;
        }
    }
}
