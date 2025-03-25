package org.algorithms.io.graphs;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    // Time complexity O(V+E) and space O(V)
    static ArrayList<Integer> topologicalSort(
            ArrayList<ArrayList<Integer>> adj
    ) {
        var vertexes = adj.size();
        var isVisited = new boolean[vertexes];
        Stack<Integer> stack = new Stack<>();
        var response = new ArrayList<Integer>();
        for (int v = 0; v < vertexes; v++) {
            if (!isVisited[v]) {
                sort(v, isVisited, stack, adj);
            }
        }
        while (!stack.isEmpty()) {
            response.add(stack.pop());
        }

        return response;
    }

    private static void sort(int v, boolean[] isVisited, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj) {
        isVisited[v] = true;
        for (int edge : adj.get(v)) {
            if (!isVisited[edge])
                sort(edge, isVisited, stack, adj);
        }
        stack.push(v);
    }
}
