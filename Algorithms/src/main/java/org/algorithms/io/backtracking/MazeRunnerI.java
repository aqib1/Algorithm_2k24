package org.algorithms.io.backtracking;

public class MazeRunnerI {
    private static final int[] MOVE = {-1, 0, 1, 0, -1};
    private int[][] maze;
    private boolean[][] isVisited;
    private int[] destination;

    public static void main(String[] args) {
        var maze = new MazeRunnerI();
        System.out.println(
                maze.hasPath(
                        new int[][] {
                                {0,0,1,0,0},
                                {0,0,0,0,0},
                                {0,0,0,1,0},
                                {1,1,0,1,1},
                                {0,0,0,0,0}
                        },
                        new int[] {0, 4},
                        new int[] {4, 4}
                )
        );
    }

    // Time complexity O(N * M) and space O(N * M)
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        this.maze = maze;
        this.isVisited = new boolean[maze.length][maze[0].length];
        this.destination = destination;
        return hasPath(start[0], start[1]);
    }

    private boolean hasPath(int x, int y) {
        if(isVisited[x][y]) {
            return false;
        }
        if(x == destination[0] && y == destination[1]) {
            return true;
        }
        isVisited[x][y] = true;
        for(int move = 0; move < MOVE.length - 1; move++) {
            int newX = x;
            int newY = y;

            while(newX >= 0 && newX < maze.length && newY >= 0 && newY < maze[newX].length && maze[newX][newY] == 0) {
                newX += MOVE[move];
                newY += MOVE[move + 1];
            }

            if(hasPath(newX - MOVE[move], newY - MOVE[move + 1]))
                return true;
        }

        return false;
    }
}
