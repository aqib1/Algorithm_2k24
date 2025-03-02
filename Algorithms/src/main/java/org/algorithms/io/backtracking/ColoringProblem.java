package org.algorithms.io.backtracking;

// Np-complete
public class ColoringProblem {

    public static void main(String[] args) {
        var c = new ColoringProblem(
                new int[][]{
                        {0, 1, 1, 1, 0, 0},
                        {1, 0, 1, 0, 1, 1},
                        {1, 1, 0, 1, 0, 1},
                        {1, 0, 1, 0, 1, 1},
                        {0, 1, 0, 0, 0, 1},
                        {0, 1, 1, 1, 1, 0}
                },
                4
        );
        c.solve();
    }

    private final int[][] adjacencyMatrix;
    private final int numberOfColors;
    private final int[] assignedColors;
    private final int vertexes;
    public ColoringProblem(
            int [][] adjacencyMatrix,
            int numberOfColors
    ) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.numberOfColors = numberOfColors;
        this.vertexes = adjacencyMatrix[0].length;
        this.assignedColors = new int[vertexes];
    }

    public void solve() {
        if(setColor(0)) {
            printColor();
        } else {
            System.out.println("Solution is not possible");
        }
    }

    private boolean setColor(int vertexIndex) {
        if(vertexIndex == vertexes) {
            return true;
        }

        for(int color = 1; color <= numberOfColors; color++) {
            if(isValid(vertexIndex, color)) {
                assignedColors[vertexIndex] = color;
                if(setColor(vertexIndex + 1)) {
                    return true;
                }
            }

            // backtrack as color value increment in loop
        }

        return false;
    }

    private boolean isValid(int vertexIndex, int color) {
        for(int i = 0; i < vertexes; i++) {
            if(adjacencyMatrix[vertexIndex][i] == 1
                    && color == assignedColors[i]) {
                return false;
            }
        }

        return true;
    }

    private void printColor() {
        for(int i = 0; i < assignedColors.length; i++) {
            System.out.println("Node : " + (i+1) + " assigned color " + assignedColors[i]);
        }
    }
}
