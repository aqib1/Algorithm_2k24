package org.algorithms.io.backtracking;

// NP-Complete problem
public class SudokuProblem {
    private final int[][] sudokuTable;
    public SudokuProblem(int[][] sudokuTable) {
        this.sudokuTable = sudokuTable;
    }

    public void solveSudoku() {
    }

    public boolean solve(int x, int y) {
        return false;
    }

    public boolean isValid(int x, int y, int amount) {
        return false;
    }

    private void showSudoku() {
        
    }

    private static class Constants {
        private Constants() {

        }

        public static final int BOARD_SIZE = 9;
        public static final int MIN_NUMBER = 1;
        public static final int MAX_NUMBER = 9;
        public static final int BOX_SIZE = 3;
    }
}
