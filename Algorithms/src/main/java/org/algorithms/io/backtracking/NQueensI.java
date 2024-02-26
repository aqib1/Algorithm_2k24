package org.algorithms.io.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueensI {
    public static void main(String[] args) {
        var nqueue = new NQueensI();
        var res = nqueue.solveNQueens(4);
        for(var r: res) System.out.println(r);
    }

    private final List<List<String>> result = new ArrayList<>();
    private int numberOfQueens;
    private char[][] board;
    public List<List<String>> solveNQueens(int n) {
        this.numberOfQueens = n;
        initBoard();
        setQueens(0);
        return result;
    }

    private void setQueens(int row) {
        if(row == numberOfQueens) {
            prepareBoard();
            return;
        }

        for(int column = 0; column < numberOfQueens; column++) {
            if(isSafe(row, column)) {
                this.board[row][column] = 'Q';
                setQueens(row + 1);
                this.board[row][column] = '.';
            }
        }
    }

    private boolean isSafe(int row, int column) {
        // check top
        for(int r = row; r >= 0; r--) {
            if(board[r][column] == 'Q')
                return false;
        }

        // check top left
        for(int r = row, col = column; r >= 0 && col >= 0; r--, col--) {
            if(board[r][col] == 'Q')
                return false;
        }

        // check top right
        for(int r = row, col = column; r >= 0 && col < numberOfQueens; r--, col++) {
            if(board[r][col] == 'Q')
                return false;
        }

        return true;
    }

    private void prepareBoard() {
        var prepare = new ArrayList<String>();
        for(var b: board) {
            prepare.add(new String(b));
        }

        result.add(prepare);
    }

    private void initBoard() {
        this.board = new char[numberOfQueens][numberOfQueens];
        for(int i = 0; i < numberOfQueens; i++) {
            Arrays.fill(this.board[i], '.');
        }
    }
}
