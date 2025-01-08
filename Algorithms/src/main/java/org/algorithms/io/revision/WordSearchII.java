package org.algorithms.io.revision;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {
    static class Trie {
        private static final int LIMIT = 26;
        private final Trie[] nodes;
        private int count;
        private int end;

        public Trie() {
            this.nodes = new Trie[LIMIT];
        }

        public void insert(String word) {
            var current = this;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (current.nodes[idx] == null) {
                    current.nodes[idx] = new Trie();
                }
                current = current.nodes[idx];
                current.count++;
            }
            current.end++;
        }

        public boolean containsKey(char key) {
            int idx = key - 'a';
            return idx >= 0 && idx < LIMIT && this.nodes[idx] != null;
        }

        public Trie get(char key) {
            int idx = key - 'a';
            return this.nodes[idx];
        }
    }

    private static final int[] MOVE = {0, -1, 0, 1, 0};

    // Time O(M * N * L)
    // Space O(L)
    public List<String> findWords(char[][] board, String[] words) {
        var response = new HashSet<String>();
        var trie = new Trie();
        for (var word : words) {
            trie.insert(word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (trie.containsKey(board[i][j])) {
                    findWords(i, j, "", board, trie.get(board[i][j]), response);
                }
            }
        }

        return new ArrayList<>(response);
    }

    public void findWords(int i, int j, String current, char[][] board, Trie trie, Set<String> response) {
        if(board[i][j] == '#') {
            return;
        }

        current = current.concat(String.valueOf(board[i][j]));
        if (trie.end > 0) {
            response.add((current));
        }

        char key = board[i][j];
        board[i][j] = '#';
        for(int m = 0; m < MOVE.length - 1; m++) {
            int newI = i + MOVE[m];
            int newJ = j + MOVE[m + 1];
            if(newI >= 0 && newI < board.length
                && newJ >= 0 && newJ < board[newI].length
                    && trie.containsKey(board[newI][newJ])) {
                findWords(newI, newJ, current, board, trie.get(board[newI][newJ]), response);
            }
        }

        board[i][j] = key;
    }

    public static void main(String[] args) {
        var word = new WordSearchII();
        System.out.println(
                word.findWords(
                        new char[][] {
                                {'o', 'a', 'b', 'n'},
                                {'o', 't', 'a', 'e'},
                                {'a', 'h', 'k', 'r'},
                                {'a', 'f', 'l', 'v'}
                        },
                        new String[] {"oa","oaa"}
                )
        );
    }
}
