package org.algorithms.io.backtracking;

import java.util.LinkedList;
import java.util.Queue;

public class MazeRunnerUsingQueueI {
  // Time complexity O(n*m) and space O(n*m)
    public static void main(String[] args) {
        var m = new MazeRunnerUsingQueueI();
        System.out.println(
                m.hasPath(
                        new int[][]{
                                {0, 0, 1, 0, 0},
                                {0, 0, 0, 0, 0},
                                {0, 0, 0, 1, 0},
                                {1, 1, 0, 1, 1},
                                {0, 0, 0, 0, 0}
                        },
                        new int[]{0, 4},
                        new int[]{4, 4}
                )
        );
    }

    private static final int[] MOVES = {-1, 0, 1, 0, -1};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> bfs = new LinkedList<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        bfs.add(start);
        visited[start[0]][start[1]] = true;
        while (!bfs.isEmpty()) {
            var location = bfs.poll();
            if (location[0] == destination[0] && location[1] == destination[1]) {
                return true;
            }
            for (int move = 0; move < MOVES.length - 1; move++) {
                var x = location[0];
                var y = location[1];
                while (x >= 0 && x < maze.length
                        && y >= 0 && y < maze[x].length && maze[x][y] == 0) {
                    x += MOVES[move];
                    y += MOVES[move + 1];
                }

                x -= MOVES[move];
                y -= MOVES[move + 1];
                if (!visited[x][y]) {
                    visited[x][y] = true;
                    bfs.add(new int[]{x, y});
                }
            }
        }
        return false;
    }
}
