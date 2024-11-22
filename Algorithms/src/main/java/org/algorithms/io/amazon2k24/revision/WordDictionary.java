package org.algorithms.io.amazon2k24.revision;

public class WordDictionary {
    static class TrieNode {
        private static final int MAX_LIMIT = 26;
        private final TrieNode []nodes;
        private char key;
        private int end;
        private int count;
        public TrieNode() {
            this.nodes = new TrieNode[MAX_LIMIT];
        }

        public void insert(String word) {
            TrieNode current = this;
            for(char ch: word.toCharArray()) {
                int idx = ch - 'a';
                if(current.nodes[idx] == null) {
                    current.nodes[idx] = new TrieNode();
                }
                current = current.nodes[idx];
                current.key = ch;
                current.count++;
            }
            current.end++;
        }

        /*
        *    a . f
        *        a
        *      /   \
        *     b     c
        *    /       \
        *   d         f
        *
        * */
        public boolean search(String word) {
            return search(0, this, word);
        }

        private boolean search(int index, TrieNode node, String word) {
            for(int i = index; i < word.length(); i++) {
                if(word.charAt(i) == '.') {
                    for(TrieNode child: node.nodes) {
                        if(child != null) {
                            search(i + 1, child, word);
                        }
                    }
                } else {
                    int idx = word.charAt(i) - 'a';
                    if(node.nodes[idx] == null) {
                        return false;
                    }
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
        this.root.insert(word);
    }

    public boolean search(String word) {
        return this.root.search(word);
    }


    public static void main(String[] args) {
        var wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");

        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
//        System.out.println(wordDictionary.search(".ad"));
//        System.out.println(wordDictionary.search("b.."));
    }
}
