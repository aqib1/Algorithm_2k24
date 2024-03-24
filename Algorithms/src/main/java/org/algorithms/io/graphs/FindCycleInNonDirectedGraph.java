package org.algorithms.io.graphs;

import java.util.ArrayList;

public class FindCycleInNonDirectedGraph {

    // Time complexity O(V + E) and space O(V)
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        var isVisited = new boolean[adj.size()];
        for(int v = 0; v < adj.size(); v++) {
            if(!isVisited[v] && isCycle(v, adj, isVisited, -1)) {
                return true;
            }
        }

        return false;
    }


    public boolean isCycle(
            int vertex,
            ArrayList<ArrayList<Integer>> adj,
            boolean[] isVisited,
            int parent
    ) {
        if (isVisited[vertex])
            return true;

        isVisited[vertex] = true;

        for(int edge: adj.get(vertex)) {
            if(edge != parent  && isCycle(edge, adj, isVisited, vertex))
                return true;
        }

        return false;
    }
}
