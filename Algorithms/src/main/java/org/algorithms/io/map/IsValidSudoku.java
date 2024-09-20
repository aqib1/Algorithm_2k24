package org.algorithms.io.map;

import java.util.HashSet;
public class IsValidSudoku {

    public static void main(String[] args) {
        System.out.println(
                isValidSudoku(
                        new char[][]{
                                {'.','.','.','.','5','.','.','1','.'},
                                {'.','4','.','3','.','.','.','.','.'},
                                {'.','.','.','.','.','3','.','.','1'},
                                {'8','.','.','.','.','.','.','2','.'},
                                {'.','.','2','.','7','.','.','.','.'},
                                {'.','1','5','.','.','.','.','.','.'},
                                {'.','.','.','.','.','2','.','.','.'},
                                {'.','2','.','9','.','.','.','.','.'},
                                {'.','.','4','.','.','.','.','.','.'}
                        }
                )
        );
    }

    // Time complexity O(9*9) = O(1)
    // Space O(9*9) with more objects  
    public static boolean isValidSudoku(char[][] board) {
        for (char[] chars : board) {
            var unique = new HashSet<Character>();
            for (char aChar : chars) {
                if(aChar != '.') {
                    if (unique.contains(aChar))
                        return false;

                    unique.add(aChar);
                }
            }
        }

        for (int row = 0; row < board.length; row++) {
            var unique = new HashSet<Character>();
            for (int col = 0; col < board[row].length; col++) {
                var aChar = board[col][row];
                if(aChar != '.') {
                    if (unique.contains(aChar))
                        return false;

                    unique.add(aChar);
                }
            }
        }

        for(int row = 0; row < board.length; row+=3) {
            for(int col = 0; col < board[row].length; col+=3) {
                var unique = new HashSet<Character>();
                for(int subRow = row; subRow < row + 3; subRow++) {
                    for(int subCol = col; subCol < col + 3; subCol++) {
                        var aChar = board[subRow][subCol];
                        if(aChar != '.') {
                            if (unique.contains(aChar))
                                return false;

                            unique.add(aChar);
                        }
                    }
                }
            }
        }

        return true;
    }

    // Time complexity O(9*9) = O(1)
    // Space O((9*9) * 3) 3 space points for each number O(1)
    public boolean isValidSudokuShort(char[][] board) {
        /*
         * For each number in row we will encode -> row(number)
         * For each number is column we will encode -> (number)col
         * For each number in 3 x 3 grid we will encode -> row/3(number)col/3
         */
        var seen = new HashSet<String>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    var encode = "(" + board[i][j] + ")";
                    if (!seen.add(encode + i) ||
                            !seen.add(j + encode) ||
                            !seen.add((i / 3) + encode + (j / 3))) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
