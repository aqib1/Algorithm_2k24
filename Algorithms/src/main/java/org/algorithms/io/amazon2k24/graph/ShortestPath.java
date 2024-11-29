package org.algorithms.io.amazon2k24.graph;

import java.util.*;

public class ShortestPath {
    public static void main(String[] args) {
        var s = new ShortestPath();

        System.out.println(Arrays.toString(s.shortestPath(new int[][]{
                {0,1},{0,3},{3,4},{4,5},{5,6},{1,2},{2,6},{6,7},{7,8},{6,8}}, 9, 10, 0)));
    }
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        // add nodes
        for(int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // add edges
        for(int e = 0; e < m; e++) {
            adjacencyList.get(edges[e][0]).add(edges[e][1]);
            adjacencyList.get(edges[e][1]).add(edges[e][0]);
        }

        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, -1);
        dist[src] = 0;
        Queue<Integer> lifo = new LinkedList<>();
        lifo.add(src);
        visited[src] = true;
        while(!lifo.isEmpty()) {
            int curr = lifo.poll();

            for(int v: adjacencyList.get(curr)) {
                if(!visited[v]) {
                    visited[v] = true;
                    lifo.add(v);
                    dist[v] = dist[curr] + 1;
                }
            }
        }

        return dist;
    }
}
