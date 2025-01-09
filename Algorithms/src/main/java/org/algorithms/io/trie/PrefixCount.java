package org.algorithms.io.trie;

public class PrefixCount {
    static class Trie {
        private static final int LIMIT = 26;
        private final Trie[] nodes;
        private int count;
        private int end;

        public Trie() {
            this.nodes = new Trie[LIMIT];
        }

        public void insert(String data) {
            var root = this;
            char[] ch = data.toCharArray();
            for(char c: ch) {
                int idx = c - 'a';
                if(root.nodes[idx] == null) {
                    root.nodes[idx] = new Trie();
                }

                // deep
                root = root.nodes[idx];
                root.count++;
            }
            root.end++;
        }


        public int findPrefix(String pref) {
            var root = this;
            char[] ch = pref.toCharArray();
            for(char c: ch) {
                int idx = c - 'a';
                if(root.nodes[idx] == null) return 0;
                root = root.nodes[idx];
            }

            return root.count;
        }
    }

    public int prefixCount(String[] words, String pref) {
        var trie = new Trie();
        // Time complexity O(WL) where w is number of words and L avg len of each word
        // Space complexity O(NK) where N is number of nodes and K is total number of unique characters
        for(var word: words) trie.insert(word);
        return trie.findPrefix(pref);
    }


    public static void main(String[] args) {
        var prefixCount = new PrefixCount();
        System.out.println(
                prefixCount.prefixCount(new String[] {"pay","attention","practice","attend"}, "at")
        );
    }
}
