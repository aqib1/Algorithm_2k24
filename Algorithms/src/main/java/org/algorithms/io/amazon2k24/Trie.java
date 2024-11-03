package org.algorithms.io.amazon2k24;

public class Trie {
    private static final Integer LIMIT = 26;
    private final Trie[] trie;
    private int count;
    private boolean isComplete;

    public static void main(String[] args) {
        var trie = new Trie();
        trie.insert("abcd");
        System.out.println(trie.containsAll("abcdK"));
    }

    public Trie() {
        trie = new Trie[LIMIT];
    }

    public void insert(String data) {
        data = data.toLowerCase();
        Trie current = this;

        for(char key: data.toCharArray()) {
            int idx = key - 'a';
            // check if you need to insert
            if(current.trie[idx] == null) {
                current.trie[idx] = new Trie();
            }
            // if not then just move further down
            current = current.trie[idx];
            current.count++;
        }
        current.isComplete = true;
    }

    public int searchSubString(String sub) {
        sub = sub.toLowerCase();
        Trie current = this;
        for(char c: sub.toCharArray()) {
            int idx = c - 'a';
            if(current.trie[idx] == null) {
                return 0;
            }

            current = current.trie[idx];
        }

        return current.count;
    }

    public boolean containsAll(String value) {
        value = value.toLowerCase();
        Trie current = this;
        for(char c: value.toCharArray()) {
            int idx = c - 'a';
            if(current.trie[idx] == null) {
                return false;
            }
            current = current.trie[idx];
        }

        return current.isComplete;
    }
}
