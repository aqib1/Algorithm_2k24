package org.algorithms.io.amazon2k24.revision;

public class WordSearch2D {

    public static void main(String[] args) {
        var word = new WordSearch2D();
        System.out.println(
                word.exist(
                        new char[][] {
                                {'A', 'B', 'C', 'E'},
                                {'S', 'F', 'E', 'S'},
                                {'A', 'D', 'E', 'E'}
                        },
                        "ABCESEEEFS"
                )
        );
    }

    private static final int []MOVE = {0, -1, 0, 1, 0};
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == word.charAt(0) &&
                        wordExists(i, j, 1, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean wordExists(int row, int col, int index, char[][] board, String word) {
        if (index == word.length()) return true;

        board[row][col] = '#';

        for (int d = 0; d < MOVE.length - 1; ++d) {
            int newRow = row + MOVE[d];
            int newCol = col + MOVE[d + 1];
            if (newRow >= 0 &&
                    newRow < board.length &&
                    newCol >= 0 &&
                    newCol < board[row].length &&
                    board[newRow][newCol] == word.charAt(index)
            ) {
                if (wordExists(newRow, newCol, index + 1, board, word))
                    return true;
            }
        }

        /* Step 4). clean up and return the result. */
        board[row][col] = word.charAt(index - 1);
        return false;
    }
}
