package org.algorithms.io.educative;

import java.util.Arrays;

public class DijkstraAlgo {
    public static void main(String[] args) {
        var d = new DijkstraAlgo();
        d.dijkstra(new int[][] {{ 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                        { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                        { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                        { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                        { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                        { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                        { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                        { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                        { 0, 0, 2, 0, 0, 0, 6, 7, 0 }}, 0, 9);
    }


   private void printSolution(int dist[])
    {
        System.out.println(
                "Vertex \t\t Distance from Source");
        for (int i = 0; i < 9; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }

    public void dijkstra(int[][] adjacencyMetric, int start, int vertices) {
        int []dist = new int[vertices];
        boolean []visited = new boolean[vertices];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;

        for(int i = 0; i < vertices - 1; i++) {
            int minDistIndex = minDistance(dist, visited);

            visited[minDistIndex] = true;

            for(int j = 0; j < vertices; j++) {
                if(!visited[j] && adjacencyMetric[minDistIndex][j] != 0
                        && dist[minDistIndex] != Integer.MAX_VALUE
                       && dist[minDistIndex] + adjacencyMetric[minDistIndex][j] < dist[j] ) {
                        dist[j] = dist[minDistIndex] + adjacencyMetric[minDistIndex][j];
                }
            }
        }

         printSolution(dist);
    }

    private int minDistance(int[] dist, boolean[] visited) {
        int minIndex = -1;
        int minDist = Integer.MAX_VALUE;
        for(int i = 0; i < dist.length; i++) {
            if(!visited[i] && dist[i] <= minDist) {
                minDist = dist[i];
                minIndex = i;
            }
        }

        return minIndex;
    }
}
