package org.algorithms.io.amazon2k25;

public class TrieII {
    private static final int LIMIT = 26;
    private int end;
    private int count;
    private final TrieII[] nodes;
    public TrieII() {
        this.nodes = new TrieII[LIMIT];
    }

    public void insert(String word) {
        var current = this;
        for(char ch: word.toCharArray()) {
            int idx = ch - 'a';
            if(current.nodes[idx] == null) {
                current.nodes[idx] = new TrieII();
            }
            current = current.nodes[idx];
            current.count++;
        }

        current.end++;
    }


    public int countWordsEqualTo(String word) {
        var current = this;
        for(char ch: word.toCharArray()) {
            int idx = ch - 'a';
            if(current.nodes[idx] == null)
                return 0;
            current =  current.nodes[idx];
        }

        return current.end;
    }

    public int countWordsStartingWith(String prefix) {
        var current = this;
        for(char ch: prefix.toCharArray()) {
            int idx = ch - 'a';
            if(current.nodes[idx] == null)
                return 0;
            current =  current.nodes[idx];
        }

        return current.count;
    }

    public void erase(String word) {
        var current = this;
        for(char ch: word.toCharArray()) {
            int idx = ch - 'a';
            if(current.nodes[idx] != null)
                current = current.nodes[idx];
            current.count--;
        }
        current.end--;
    }
}
