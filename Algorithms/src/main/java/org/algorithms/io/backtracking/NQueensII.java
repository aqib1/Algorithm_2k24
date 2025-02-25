package org.algorithms.io.backtracking;

import java.util.Arrays;

public class NQueensII {
    // Time complexity O(N!) and Space complexity O(N^2)
    public static void main(String[] args) {
        var nqueue = new NQueensII();
        System.out.println(nqueue.totalNQueens(1));
    }
    private int count;
    private char[][] board;
    private int numberOfQueens;
    public int totalNQueens(int n) {
        this.numberOfQueens = n;
        initBoard();
        setQueens(0);
        return count;
    }

    private void initBoard() {
        this.board = new char[numberOfQueens][numberOfQueens];
        for(int i = 0; i < numberOfQueens; i++) {
            Arrays.fill(board[i], '.');
        }
    }

    public void setQueens(int row) {
        if(row == numberOfQueens) {
            count++;
            return;
        }

        for(int column = 0; column < numberOfQueens; column++) {
            if(isSafe(row, column)) {
                board[row][column] = 'Q';
                setQueens(row + 1);
                board[row][column] = '.';
            }
        }
    }

    private boolean isSafe(int row, int column) {
        for(int r = row; r >= 0; r--)
            if(board[r][column] == 'Q')
                return false;

        for(int r = row, col = column; r >= 0 && col >= 0; r--, col--) {
            if(board[r][col] == 'Q')
                return false;
        }

        for(int r = row, col = column; r >= 0 && col < numberOfQueens; r--, col++) {
            if(board[r][col] == 'Q')
                return false;
        }

        return true;
    }
}
