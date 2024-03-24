package org.algorithms.io.graphs;

import java.util.*;

public class CourseScheduling {

    // Time complexity O(V + E) and space O(V)
    public static void main(String[] args) {
        var c = new CourseScheduling();
        var response = c.findOrder(2, new int[][]{});

        System.out.println(Arrays.toString(response));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        var graph = constructGraph(numCourses, prerequisites);
        if(hasCycle(graph)) {
            return new int[] {};
        }

        var response = new int[numCourses];
        var visited = new boolean[numCourses];
        Queue<Integer> queue = new LinkedList<>();
         for (int vertex = 0; vertex < graph.size(); vertex++) {
            if (!visited[vertex]) {
                topologicalSort(vertex, visited, graph, queue);
            }
        }

        int index = 0;
        while (!queue.isEmpty()) {
            response[index++] = queue.poll();
        }

        return response;
    }

    private boolean hasCycle(ArrayList<ArrayList<Integer>> graph) {
        var isVisited = new boolean[graph.size()];
        var inStack = new boolean[graph.size()];

        for(int v = 0; v < graph.size(); v++) {
            if(!isVisited[v] && hasCycle(v, isVisited, inStack, graph)) {
                return true;
            }
        }

        return false;
    }

    private boolean hasCycle(
            int v,
            boolean[] isVisited,
            boolean[] inStack,
            ArrayList<ArrayList<Integer>> graph
    ) {
        if(inStack[v])
            return true;

        isVisited[v] = true;
        inStack[v] = true;

        for(int edge: graph.get(v)) {
            if(!isVisited[edge]
                 && hasCycle(edge, isVisited, inStack, graph)) {
                return true;
            } else if (inStack[edge]) {
                return true;
            }
        }
        inStack[v] = false;
        return false;
    }

    private ArrayList<ArrayList<Integer>> constructGraph(
            int numCourses,
            int[][] prerequisites
    ) {
        var graph = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < numCourses; i++) {
            graph.add(i, new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[0]).add(prerequisite[1]);
        }

        return graph;
    }

    private void topologicalSort(
            int v,
            boolean[] visited,
            ArrayList<ArrayList<Integer>> graph,
            Queue<Integer> queue
    ) {
        visited[v] = true;
        for(int edge : graph.get(v)) {
            if(!visited[edge]) {
                topologicalSort(edge, visited, graph, queue);
            }
        }
        queue.add(v);
    }
}
