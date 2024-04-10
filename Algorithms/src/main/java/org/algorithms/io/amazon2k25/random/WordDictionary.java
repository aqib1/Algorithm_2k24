package org.algorithms.io.amazon2k25.random;

public class WordDictionary {
    static class TrieNode {
        private static final int LIMIT = 26;
        private int count;
        private int end;
        private final TrieNode[] nodes;
        public TrieNode() {
            this.nodes = new TrieNode[LIMIT];
        }
        public void insert(String word) {
            var current = this;
            for(char ch: word.toCharArray()) {
                int idx = ch - 'a';
                if(current.nodes[idx] == null) {
                    current.nodes[idx] = new TrieNode();
                }
                current = current.nodes[idx];
                current.count++;
            }

            current.end++;
        }
        public boolean search(String word) {
            return search(0, this, word);
        }
        public boolean search(int level, TrieNode node, String word) {
            for(int i = level; i < word.length(); i++) {
                var ch = word.charAt(i);
                if(ch == '.') {
                    for(var branch: node.nodes) {
                        if(branch != null) {
                            if(search(i + 1, branch, word)) {
                                return true;
                            }
                        }
                    }
                    return false;
                } else {
                    int idx = ch - 'a';
                    if(node.nodes[idx] == null)
                        return false;
                    node = node.nodes[idx];
                }
            }

            return node.end > 0;
        }
    }
    private final TrieNode root;
    public WordDictionary() {
        this.root = new TrieNode();
    }
    public void addWord(String word) {
        root.insert(word);
    }
    public boolean search(String word) {
        return root.search(word);
    }
}
