package org.algorithms.io.amazon2k24.revision;

public class WordDictionary {
    static class TrieNode {
        private static final int MAX_LIMIT = 26;
        private final TrieNode[] nodes;
        private char key = Character.MIN_VALUE;
        private int end;
        private int count;
        private boolean isEnd;

        public TrieNode() {
            this.nodes = new TrieNode[MAX_LIMIT];
        }

        @Override
        public String toString() {
            var builder = new StringBuilder();
            buildToString(this, "", builder);
            return builder.toString();
        }

        private void buildToString(TrieNode trieNode, String current, StringBuilder builder) {
            if(trieNode == null)
                return;
            if(trieNode.key != Character.MIN_VALUE)
                current = current.concat(String.valueOf(trieNode.key));
            if (trieNode.isLeaf()) {
                builder.append(current).append(" ");
                return;
            }
            for (TrieNode node : trieNode.nodes) {
                if(node != null) {
                    buildToString(node, current, builder);
                }
            }
        }

        public boolean isLeaf() {
            return isEnd;
        }

        public void insert(String word) {
            TrieNode current = this;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (current.nodes[idx] == null) {
                    current.nodes[idx] = new TrieNode();
                }
                current = current.nodes[idx];
                current.key = ch;
                current.count++;
            }
            current.end++;
            current.isEnd = true;
        }

        public boolean search(String word) {
            return search(0, this, word);
        }

        private boolean search(int index, TrieNode node, String word) {
            for (int i = index; i < word.length(); i++) {
                if (word.charAt(i) == '.') {
                    for (TrieNode child : node.nodes) {
                        if (child != null) {
                            var res = search(i + 1, child, word);
                            if(res) return true;
                        }
                    }
                    return false;
                } else {
                    int idx = word.charAt(i) - 'a';
                    if (node.nodes[idx] == null) {
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

    @Override
    public String toString() {
        return this.root.toString();
    }

    public static void main(String[] args) {
        var wordDictionary = new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");


        System.out.println(wordDictionary.search("a"));
        System.out.println(wordDictionary.search(".at"));
        wordDictionary.addWord("bat");
        System.out.println(wordDictionary.search(".at"));
        System.out.println(wordDictionary.search("an."));
        System.out.println(wordDictionary.search("a.d."));
        System.out.println(wordDictionary.search("b."));
        System.out.println(wordDictionary.search("a.d"));
        System.out.println(wordDictionary.search("."));

//        System.out.println(wordDictionary);
    }
}
