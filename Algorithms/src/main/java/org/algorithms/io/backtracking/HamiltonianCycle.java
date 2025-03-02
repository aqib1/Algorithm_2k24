package org.algorithms.io.backtracking;
// NP-complete
public class HamiltonianCycle {
    private final int noOfVertex;
    private final int[] hamiltonianPath;
    private final int[][] adjacencyMatrix; // graph

    // Time complexity O(N!) and space is O(N)
    public static void main(String[] args) {
        var hamiltonianCycle = new HamiltonianCycle(
                new int[][]{
                        {0, 1, 0, 0, 0, 1},
                        {1, 0, 1, 0, 0, 0},
                        {0, 1, 0, 0, 1, 0},
                        {0, 0, 0, 0, 1, 1},
                        {0, 0, 1, 1, 0, 1},
                        {1, 0, 0, 1, 1, 0}
                }
        );

        hamiltonianCycle.printHamiltonianPath();
    }

    public HamiltonianCycle(
            int[][] adjacencyMatrix
    ) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.noOfVertex = adjacencyMatrix[0].length;
        this.hamiltonianPath = new int[noOfVertex];
    }

    public void printHamiltonianPath() {
        this.hamiltonianPath[0] = 0;
        if (findSolution(1)) {
            printPath();
        } else {
            System.out.println("Path does not exists");
        }
    }

    private boolean findSolution(int position) {
        if (position == noOfVertex) {
            return adjacencyMatrix[hamiltonianPath[position - 1]][hamiltonianPath[0]] == 1;
        }

        for (int vertex = 1; vertex < noOfVertex; vertex++) {
            if (isValid(vertex, position)) {
                hamiltonianPath[position] = vertex;
                if (findSolution(position + 1)) {
                    return true;
                }

                // backtrack
                hamiltonianPath[position] = 0;
            }
        }

        return false;
    }

    public boolean isValid(int vertex, int position) {
        // check if edge exists in between vertexes.
        if (adjacencyMatrix[hamiltonianPath[position - 1]][vertex] == 0) {
            return false;
        }

        // check if we already visited vertex
        for (int i = 0; i < position; i++) {
            if (hamiltonianPath[i] == vertex)
                return false;
        }

        return true;
    }

    public void printPath() {
        for (int j : hamiltonianPath) {
            System.out.print(j + " - ");
        }
        System.out.println(hamiltonianPath[0]);
    }
}
