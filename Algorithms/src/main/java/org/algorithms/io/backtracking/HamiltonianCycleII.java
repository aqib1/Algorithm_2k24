package org.algorithms.io.backtracking;

public class HamiltonianCycleII {

    private int[][] adjacencyMatrix;
    private int vertexes;
    private int[] hamiltonianCycle;

    public static void main(String[] args) {
        var h = new HamiltonianCycleII();
        System.out.println(
                h.cycle(
                        new int[][]{{0, 1, 0, 0, 0, 1},
                                {1, 0, 1, 0, 0, 0},
                                {0, 1, 0, 0, 1, 0},
                                {0, 0, 0, 0, 1, 1},
                                {0, 0, 1, 1, 0, 1},
                                {1, 0, 0, 1, 1, 0}}
                )
        );
    }

    public boolean cycle(
            int[][] adjacencyMatrix
    ) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.vertexes = adjacencyMatrix[0].length;
        this.hamiltonianCycle = new int[vertexes];

        hamiltonianCycle[0] = 0;
        if (findCycle(1)) {
            printPath();
            return true;
        } else {
            return false;
        }
    }

    public boolean findCycle(int position) {
        if (position == vertexes) {
            return adjacencyMatrix[hamiltonianCycle[position - 1]][hamiltonianCycle[0]] == 1;
        }

        for (int vertex = 1; vertex < vertexes; vertex++) {
            if (isValid(position, vertex)) {
                hamiltonianCycle[position] = vertex;
                if (findCycle(position + 1)) {
                    return true;
                }
                // backtrack
            }
        }

        return false;
    }

    private boolean isValid(int position, int vertex) {
        if (adjacencyMatrix[hamiltonianCycle[position - 1]][vertex] == 0) {
            return false;
        }

        for (int p = 0; p < position; p++) {
            if (hamiltonianCycle[p] == vertex) {
                return false;
            }
        }

        return true;
    }

    private void printPath() {
        for (int j : hamiltonianCycle) {
            System.out.print(j + " - ");
        }

        System.out.println(hamiltonianCycle[0]);
    }
}
