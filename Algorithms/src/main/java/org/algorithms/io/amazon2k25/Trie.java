package org.algorithms.io.amazon2k25;

public class Trie {
    private static final int LIMIT = 26;
    private int end;
    private int count;
    private final Trie[] nodes;
    public Trie() {
        this.nodes = new Trie[LIMIT];
    }

    public void insert(String word) {
        var current = this;
        for(char ch: word.toCharArray()) {
            int idx = ch - 'a';
            if(current.nodes[idx] == null) {
                current.nodes[idx] = new Trie();
            }
            current = current.nodes[idx];
            current.count++;
        }

        current.end++;
    }

    public boolean search(String word) {
        var current = this;
        for(char ch: word.toCharArray()) {
            int idx = ch - 'a';
            if(current.nodes[idx] == null)
                return false;
            current = current.nodes[idx];
        }

        return current.end > 0;
    }

    public boolean startsWith(String prefix) {
        var current = this;
        for(char ch: prefix.toCharArray()) {
            int idx = ch - 'a';
            if(current.nodes[idx] == null)
                return false;
            current = current.nodes[idx];
        }

        return current.count > 0;
    }
}
