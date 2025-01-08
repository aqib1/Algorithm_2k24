package org.algorithms.io.revision;

public class WordSearch2DTrie {
    static class Trie {
        private static final int LIMIT = 256;
        private final Trie[] nodes;
        public int count;
        public int end;
        public Trie() {
            this.nodes = new Trie[LIMIT];
        }

        public boolean containsKey(char ch) {
            return this.nodes[ch] != null;
        }

        public Trie getNode(char ch) {
            return this.nodes[ch];
        }

        public void insert(String data) {
            var current = this;
            for(char ch: data.toCharArray()) {
                if(current.nodes[ch] == null) {
                    current.nodes[ch] = new Trie();
                }
                current = current.nodes[ch];
                current.count++;
            }
            current.end++;
        }
    }

    private static final int[] MOVE = {0, -1, 0, 1, 0};
    public boolean exist(char[][] board, String word) {
        var trie = new Trie();
        trie.insert(word);

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(trie.containsKey(board[i][j])
                    && dfs(i, j, board, trie.getNode(board[i][j]))) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int i, int j, char[][] board, Trie trie) {
        if(trie.end > 0) return true;

        char current = board[i][j];
        board[i][j] = '#';
        for(int m = 0; m < MOVE.length - 1; m++) {
            int newI = i + MOVE[m];
            int newJ = j + MOVE[m + 1];
            if(newI >= 0 && newI < board.length &&
                newJ >=0 && newJ < board[newI].length
                    && trie.containsKey(board[newI][newJ])
                        && dfs(newI, newJ, board, trie.getNode(board[newI][newJ]))) {
                return true;
            }
        }


        board[i][j] = current;
        return false;
    }

    public static void main(String[] args) {
        var wordSearch = new WordSearch2DTrie();
        System.out.println(wordSearch.exist(
                new char[][] {
                        {'A'}
                },
                "A"
        ));
    }
}
