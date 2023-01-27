package org.algorithms.io.interviewPrep2k25.trie;

public class MapSum {
    static class Trie {
        private static final int LIMIT = 26;
        private final Trie[] nodes;
        private Integer val;

        public Trie() {
            this.nodes = new Trie[LIMIT];
        }

        // Time complexity O(N) & Space O(S * N) where S is alphabet size
        public void insert(String key, int val) {
            var current = this;
            for (var ch : key.toCharArray()) {
                int idx = ch - 'a';
                if (current.nodes[idx] == null)
                    current.nodes[idx] = new Trie();

                current = current.nodes[idx];
            }
            current.val = val;
        }

        // Time complexity O(N) & Space O(S * N) where S is alphabet size
        public int sum(String prefix) {
            var current = this;
            for (var ch : prefix.toCharArray()) {
                int idx = ch - 'a';
                if (current.nodes[idx] == null)
                    return 0;

                current = current.nodes[idx];
            }

            return sumAllChildNodes(current);
        }

        private int sumAllChildNodes(Trie current) {
            int sum = 0;
            if (current.val != null) sum += current.val;

            for (int i = 0; i < LIMIT; i++) {
                if (current.nodes[i] != null) {
                    sum += sumAllChildNodes(current.nodes[i]);
                }
            }

            return sum;
        }
    }

    private final Trie root;

    public MapSum() {
        this.root = new Trie();
    }

    public void insert(String key, int val) {
        root.insert(key, val);
    }

    public int sum(String prefix) {
        return root.sum(prefix);
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */