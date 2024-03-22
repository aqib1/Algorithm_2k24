package org.algorithms.io.graphs;

import java.util.ArrayList;

public class FindACycleInDirectedGraph {

    // Time complexity O(V + E) and space O(2V) ~ O(V)
    public boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
        var vertexes = adj.size();
        var isVisited = new boolean[vertexes];
        var inStack = new boolean[vertexes];

        for(int i = 0; i < vertexes; i++) {
            if(!isVisited[i] && isCycleUtil(i, adj, isVisited, inStack)) {
                return true;
            }
        }

        return false;
    }

    private boolean isCycleUtil(
            int i,
            ArrayList<ArrayList<Integer>> adj,
            boolean[] isVisited,
            boolean[] inStack
    ) {
        if(inStack[i])
            return true;

        inStack[i] = true;
        isVisited[i] = true;

        for(int edge : adj.get(i)) {
            if(!isVisited[edge] && isCycleUtil(edge, adj, isVisited, inStack)) {
                return true;
            } else if(inStack[edge]) {
                return true;
            }
        }
        inStack[i] = false;
        return false;
    }
}
