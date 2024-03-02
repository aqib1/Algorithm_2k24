package org.algorithms.io.backtracking;

// NP-Complete problem
public class SudokuSolver {
    public static void main(String[] args) {
        var sudoku = new SudokuSolver();
        var res = sudoku.isValidSudoku(
                new char[][]{
                        {'.','8','7','6','5','4','3','2','1'},
                        {'2','.','.','.','.','.','.','.','.'},
                        {'3','.','.','.','.','.','.','.','.'},
                        {'4','.','.','.','.','.','.','.','.'},
                        {'5','.','.','.','.','.','.','.','.'},
                        {'6','.','.','.','.','.','.','.','.'},
                        {'7','.','.','.','.','.','.','.','.'},
                        {'8','.','.','.','.','.','.','.','.'},
                        {'9','.','.','.','.','.','.','.','.'}}
        );

        System.out.println(res);
    }

    private char[][] board;

    // time complexity
    // for one row there are 9 cells to fill and there are 9 possibilities to check (1-9)
    // once one cell is fill there are 8 cells left so 9 x 8 and then 9 x 8 x 7 ...
    // so for one row is 9!
    // for all rows it will be O((9!) ^ 9) and space is constant O(81)
    public boolean isValidSudoku(char[][] board) {
        this.board = board;
        if (solve(0, 0)) {
            showSudoku();
            return true;
        } else {
            showSudoku();
            return false;
        }
    }

    public boolean solve(int row, int column) {
        if(column == Constants.BOARD_SIZE) {
            row++;
            if(row == Constants.BOARD_SIZE) {
                return true;
            } else {
                column = 0;
            }
        }

        if(board[row][column] != '.')
            return solve(row, column + 1);

        for (char num = Constants.MIN_NUMBER; num <= Constants.MAX_NUMBER; num++) {
            if (isValid(row, column, num)) {
                board[row][column] = num;
                if (solve(row, column + 1)) {
                    return true;
                }
                // backtrack
                board[row][column] = '.';
            }
        }
        return false;
    }

    public boolean isValid(int row, int column, char amount) {
        for (int i = 0; i < Constants.BOARD_SIZE; i++)
            if (board[i][column] == amount || board[row][i] == amount)
                return false;

        row = (row / Constants.BOX_SIZE) * Constants.BOX_SIZE;
        column = (column / Constants.BOX_SIZE) * Constants.BOX_SIZE;

        for (int r = row; r < row + Constants.BOX_SIZE; r++) {
            for (int c = column; c < column + Constants.BOX_SIZE; c++) {
                if (board[r][c] == amount)
                    return false;
            }
        }

        return true;
    }

    private void showSudoku() {
        for (int i = 0; i < Constants.BOARD_SIZE; i++) {
            if (i % Constants.BOX_SIZE == 0)
                System.out.println();
            for (int j = 0; j < Constants.BOARD_SIZE; j++) {
                if (j % Constants.BOX_SIZE == 0)
                    System.out.print("  ");
                System.out.print(board[i][j] + " ");
            }

            System.out.println();
        }
    }

    private static class Constants {
        private Constants() {

        }

        public static final int BOARD_SIZE = 9;
        public static final char MIN_NUMBER = '1';
        public static final char MAX_NUMBER = '9';
        public static final int BOX_SIZE = 3;
    }
}
