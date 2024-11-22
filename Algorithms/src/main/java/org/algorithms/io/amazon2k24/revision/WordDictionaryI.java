package org.algorithms.io.amazon2k24.revision;

public class WordDictionaryI {
    static class Trie {
        private final static int LIMIT = 26;
        private final Trie []branches;
        private int end;
        public Trie() {
            this.branches = new Trie[LIMIT];
        }

        public void insert(String word) {
            var current = this;
            for(char ch: word.toCharArray()) {
                int idx = ch - 'a';
                if(current.branches[idx] == null) {
                    current.branches[idx] = new Trie();
                }
                current = current.branches[idx];
            }

            current.end++;
        }

        public boolean search(String word) {
            return search(0, this, word);
        }

        public boolean search(int level, Trie node, String word) {
            for(int i = level; i < word.length(); i++) {
                char ch = word.charAt(i);
                if(ch == '.') {
                    for(var branch : node.branches) {
                        if(branch != null) {
                            if(search(i + 1, branch, word)) {
                                return true;
                            }
                        }
                    }
                    return false;
                } else {
                    int idx = ch - 'a';
                    if(node.branches[idx] == null) {
                        return false;
                    }
                    node = node.branches[idx];
                }
            }

            return node.end > 0;
        }
    }


    public static void main(String[] args) {
        var trie = new Trie();
        trie.insert("pad");
        trie.insert("pdd");
        trie.insert("paa");

        System.out.println(trie.search("p.a"));
    }
}
