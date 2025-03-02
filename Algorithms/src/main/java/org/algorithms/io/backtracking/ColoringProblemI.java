package org.algorithms.io.backtracking;

import java.util.ArrayList;
import java.util.List;

public class ColoringProblemI {


    public static void main(String[] args) {
        var c = new ColoringProblemI();
        System.out.println(
                c.graphColoring(
                        4,
                        new ArrayList<>(
                                List.of(
                                        new int[] {0, 1},
                                        new int[] {1, 2},
                                        new int[] {2, 3},
                                        new int[] {3, 0},
                                        new int[] {0, 2}
                                )
                        ),
                        3
                )
        );
    }

    private int[][] adjacencyMatrix;
    private int vertexes;
    private int[] assignedColors;
    private int colors;
    boolean graphColoring(int v, List<int[]> edges, int m) {
        // code here
        adjacencyMatrix = new int[v][v];
        this.colors = m;
        this.assignedColors = new int[v];
        this.vertexes = v;

        for(int[] edge: edges) {
            adjacencyMatrix[edge[0]][edge[1]] = 1;
            adjacencyMatrix[edge[1]][edge[0]] = 1;
        }

        if(setColors(0)) {
            printColors();
            return true;
        } else {
            return false;
        }
    }

    private boolean setColors(int vertex) {
        if(vertex == vertexes) {
            return true;
        }

        for(int color = 1; color <= colors; color++) {
            if(isValid(color, vertex)) {
                assignedColors[vertex] = color;
                if(setColors(vertex + 1)) {
                    return true;
                }
                // Backtrack
                // Backtrack
                assignedColors[vertex] = 0;
            }
        }

        return false;
    }

    private boolean isValid(int color, int vertex) {
        for(int v = 0; v < vertexes; v++) {
            if(adjacencyMatrix[v][vertex] == 1
                    && color == assignedColors[v])
                return false;
        }

        return true;
    }

    public void printColors() {
        for(int i = 0; i < assignedColors.length; i++) {
            System.out.println("Vertex " + (i + 1) + " assigned with color "+ assignedColors[i]);
        }
    }
}
