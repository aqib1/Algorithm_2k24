package org.algorithms.io.graphs;

import java.util.Arrays;

public class MazeEscape {
    public static void main(String[] args) {
        var mazeEscape = new MazeEscape();
        var maze  = new char[][] {
                {'1', '1', '1', '1', '1'},
                {'1', '2', '0', '1', '1'},
                {'1', '1', '0', '1', '1'},
                {'0', '0', '0', '0', '0'},
                {'1', '1', '1', '1', '3'}
        };

        mazeEscape.escape(maze);

        for(var m: maze) {
            System.out.println(Arrays.toString(m));
        }
    }

    // Time complexity O(V+E) and space O(V+E)
    private static final int[] MOVE = new int[]{-1, 0, 1, 0, -1};
    private void escape(char [][] maze) {
        for(int i = 0; i < maze.length; i++) {
            for(int j = 0; j < maze[i].length; j++) {
                if(maze[i][j] == '2') {
                    escape(i, j, maze);
                }
            }
        }
    }

    public boolean escape(int i, int j, char[][] maze) {
        if(foundTarget(i, j, maze))
            return true;

        for(int m = 0; m < MOVE.length - 1; m++) {
            int newI = i + MOVE[m];
            int newJ = j + MOVE[m + 1];

            if(isValidMove(newI, newJ, maze)) {
                maze[newI][newJ] = 'S';
                if(escape(newI, newJ, maze)) {
                    return true;
                }
                maze[i][j] = '0';
            }
        }

        return false;
    }

    private boolean foundTarget(int i, int j, char[][] maze) {
        for(int m = 0; m < MOVE.length - 1; m++) {
            int newI = i + MOVE[m];
            int newJ = j + MOVE[m + 1];
            if(newI >= 0 && newI < maze.length
                    && newJ >= 0 && newJ < maze[newI].length
                    && maze[newI][newJ] == '3') {
                return true;
            }
        }
        return false;
    }

    private boolean isValidMove(int newI, int newJ, char[][] maze) {
       return newI >= 0 && newI < maze.length
                && newJ >= 0 && newJ < maze[newI].length
                && maze[newI][newJ] == '0';
    }
}
