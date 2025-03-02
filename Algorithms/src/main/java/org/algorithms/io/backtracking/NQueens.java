package org.algorithms.io.backtracking;

import java.util.ArrayList;
import java.util.List;

// Np-complete
public class NQueens {

    // Time complexity O(n!) and Space is O(n^2)
    private final List<List<String>> response = new ArrayList<>();
    private char[][] board;
    private int numberOfQueens;

    public static void main(String[] args) {
        var queen = new NQueens();
        var res = queen.solveNQueens(4);
        for (var d : res) {
            System.out.println(d);
        }
    }

    public List<List<String>> solveNQueens(int n) {
        this.numberOfQueens = n;
        initBoard();
        setQueens(0, 0, this.numberOfQueens);
        return response;
    }

    private void setQueens(int row, int col, int n) {
        if(col == this.numberOfQueens) {
            col = 0;
            row++;
        }

        if(n == 0) {
            response.add(createBoard(board));
            return;
        }

        if(row == this.numberOfQueens) {
            return;
        }

        if(isValidMove(row, col)) {
            board[row][col] = 'Q';
            n--;
            setQueens(row, col + 1, n);
            n++;
            board[row][col] = '.';
        }

        setQueens(row, col + 1, n);
    }

    private boolean isValidMove(int row, int col) {
        // top-down and left-right check
        for(int i = 0; i < numberOfQueens; i++) {
            if(board[i][col] == 'Q') {
                return false;
            }

            if(board[row][i] == 'Q') {
                return false;
            }
        }

        // check diagonal from top left to current and current to bottom right
        for(int r=row, c=col; c>=0 && r>=0; c--, r--) {
            if(board[r][c] == 'Q')
                return false;
        }
        for(int r=row, c=col; c<numberOfQueens && r<numberOfQueens; c++, r++) {
            if(board[r][c] == 'Q')
                return false;
        }

        // check diagonal from current to bottom left and current to top right
        for(int r=row, c=col; r<numberOfQueens && c>=0; r++, c--) {
            if(board[r][c] == 'Q')
                return false;
        }

        for(int r=row, c=col; r>=0 && c<numberOfQueens; r--, c++) {
            if(board[r][c] == 'Q')
                return false;
        }

        return true;
    }

    private List<String> createBoard(char[][] board) {
        var res = new ArrayList<String>();
        for(var data : board) {
            res.add(new String(data));
        }
        return res;
    }

    private void initBoard() {
        this.board = new char[numberOfQueens][numberOfQueens];
        for(int i = 0; i < numberOfQueens; i++) {
            for(int j = 0; j < numberOfQueens; j++) {
                this.board[i][j] = '.';
            }
        }
    }

}
