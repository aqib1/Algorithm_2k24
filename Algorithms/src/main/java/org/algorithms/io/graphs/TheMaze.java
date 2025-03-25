package org.algorithms.io.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class TheMaze {

    public static void main(String[] args) {
        var theMaze = new TheMaze();
        System.out.println(
                theMaze.hasPath(
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

    private static final int[] MOVE = {0, -1, 0, 1, 0};

    // Time complexity O(M * N) and space is O(M+N)
    public boolean hasPath(
            int[][] maze,
            int[] start,
            int[] destination
    ) {
        var visited = new boolean[maze.length][maze[0].length];
        Queue<int[]> bfs = new LinkedList<>();
        bfs.add(start);
        while(!bfs.isEmpty()) {
            var curr = bfs.poll();
            if(isReachToDestination(curr, destination)) {
                return true;
            }
            for(int m = 0; m < MOVE.length - 1; m++) {
                int newX = curr[0];
                int newY = curr[1];

                while(newX >= 0 && newX < maze.length
                        && newY >= 0 && newY < maze[newX].length
                            && maze[newX][newY] != 1) {
                    newX += MOVE[m];
                    newY += MOVE[m + 1];
                }

                newX -= MOVE[m];
                newY -= MOVE[m + 1];

                if(!visited[newX][newY]) {
                    visited[newX][newY] = true;
                    bfs.add(new int[] {newX, newY});
                }
            }
        }

        return false;
    }

    private boolean isReachToDestination(int[] curr, int[] destination) {
        return curr[0] == destination[0]
                    && curr[1] == destination[1];
    }
}
