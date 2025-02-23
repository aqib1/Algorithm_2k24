package org.algorithms.io.backtracking;

public class NQueensProblem {
    public static void main(String[] args) {
        var nqueue = new NQueensProblem(
                4
        );
        nqueue.solve();
    }

    // Time complexity O(n!) & Space O(n^2)
    private final int [][] chessTable;
    private final int numberOfQueens;
    public NQueensProblem(int numberOfQueens) {
        this.chessTable = new int[numberOfQueens][numberOfQueens];
        this.numberOfQueens = numberOfQueens;
    }

    public void solve() {
        if(setQueen(0)) {
            print();
        } else {
            System.out.println("Solution is not possible");
        }
    }

    private boolean setQueen(int column) {
        if(column == numberOfQueens)
            return true;
        for(int row = 0; row < numberOfQueens; row++) {
            if(isPlaceValid(row, column)) {
                chessTable[row][column] = 1;

                if(setQueen(column + 1)) {
                    return true;
                }
                // BACKTRACKING onwards
                chessTable[row][column] = 0;
            }
        }
        return false;
    }

    private boolean isPlaceValid(int row, int column) {
        // check all left columns
        for(int i=column; i >= 0; i--) {
            if(chessTable[row][i] == 1)
                return false;
        }

        // check diagonal from top left to current
        for(int r=row, c=column; c>=0 && r>=0; c--, r--) {
            if(chessTable[r][c] == 1)
                return false;
        }

        // check diagonal from current to bottom left
        for(int r=row, c=column; r<numberOfQueens && c>=0; r++, c--) {
            if(chessTable[r][c] == 1)
                return false;
        }

        return true;
    }

    private void print() {
        for (int[] its : chessTable) {
            for (int anInt : its) {
                if (anInt == 1) {
                    System.out.print(" Q ");
                } else {
                    System.out.print(" - ");
                }
            }
            System.out.println();
        }
    }
}
