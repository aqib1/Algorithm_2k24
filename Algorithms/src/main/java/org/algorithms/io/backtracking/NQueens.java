package org.algorithms.io.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        var queens = new NQueens();
        var response = queens.solveNQueens(4);
        for(var d: response) {
            System.out.println(d);
        }
    }
    private List<List<String>> chessBoard;
    private int numberOfQueens;

    public List<List<String>> solveNQueens(int n) {
        this.numberOfQueens = n;
        this.chessBoard = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            var subChess = new ArrayList<String>();
            for(int j = 0; j < n; j++) {
                subChess.add(".");
            }
            chessBoard.add(subChess);
        }

        setQueens(0);
        return chessBoard;
    }

    public boolean setQueens(int column) {
        if(column == numberOfQueens)
            return true;
        for(int row = 0; row < numberOfQueens; row++) {
            if(isValidPlace(row, column)) {
                chessBoard.get(row).set(column, "Q");
                if(setQueens(column + 1)) {
                    return true;
                }
                chessBoard.get(row).set(column, ".");
            }

        }
        return false;
    }

    private boolean isValidPlace(int row, int column) {
        for(int c = column; c>=0; c--) {
            if("Q".equals(chessBoard.get(row).get(c))) {
                return false;
            }
        }

        // diagonal to top left
        for(int r = row, c = column; r >= 0 && c >= 0; r--, c--) {
            if("Q".equals(chessBoard.get(r).get(c))) {
                return false;
            }
        }

        // diagonal to bottom right
        for(int r = row, c = column; r < numberOfQueens && c >= 0; r++, c--) {
            if("Q".equals(chessBoard.get(r).get(c))) {
                return false;
            }
        }

        return true;
    }
}
