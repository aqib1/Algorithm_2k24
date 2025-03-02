package org.algorithms.io.backtracking;


public class HamiltonianCycleI {

    public static void main(String[] args) {
        var hm = new HamiltonianCycleI();
        System.out.println(hm.check(new int[][]{
                {0, 1, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0},
                {0, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 1},
                {0, 0, 1, 1, 0, 1},
                {1, 0, 0, 1, 1, 0}
        }));
        hm.printPath();
    }

    private int[][] adjacencyMatrix;
    private int[] hamiltonPath;
    private int noOfVertexes;

    boolean check(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.noOfVertexes = adjacencyMatrix[0].length;
        this.hamiltonPath = new int[noOfVertexes];
        hamiltonPath[0] = 0;
        return findHamiltonCycle(1);
    }

    private boolean findHamiltonCycle(int position) {
        if(position == noOfVertexes) {
            return adjacencyMatrix[hamiltonPath[position - 1]][hamiltonPath[0]] == 1;
        }
        for(int vertex = 1; vertex < noOfVertexes; vertex++) {
            if(isValid(vertex, position)) {
                hamiltonPath[position] = vertex;
                if(findHamiltonCycle(position + 1)) {
                    return true;
                }

                // BACKTRACK
                // backtrack
                hamiltonPath[position] = 0;
            }
        }
        return false;
    }

    private boolean isValid(int vertex, int position) {
        if(adjacencyMatrix[hamiltonPath[position - 1]][vertex] == 0) {
            return false;
        }

        for(int i = 0; i < position; i++) {
            if(hamiltonPath[i] == vertex)
                return false;
        }

        return true;
    }

    public void printPath() {
        for (int j : hamiltonPath) {
            System.out.print(j + " - ");
        }
        System.out.println(hamiltonPath[0]);
    }
}
