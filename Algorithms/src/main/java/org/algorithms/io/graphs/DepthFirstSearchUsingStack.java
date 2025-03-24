package org.algorithms.io.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearchUsingStack {
    public static void main(String[] args) {
        var v1 = new Vertex("A");
        var v2 = new Vertex("B");
        var v3 = new Vertex("C");
        var v4 = new Vertex("D");
        var v5 = new Vertex("E");

        List<Vertex> list = new ArrayList<>();
        v1.addVertex(v2);
        v1.addVertex(v3);
        v3.addVertex(v4);
        v4.addVertex(v5);

        list.add(v1);
        list.add(v2);
        list.add(v3);
        list.add(v4);
        list.add(v5);

        var dfs = new DepthFirstSearchUsingStack();
        dfs.dfs(list);
    }
    private final Stack<Vertex> lifo;
    public DepthFirstSearchUsingStack() {
        this.lifo = new Stack<>();
    }
    public void dfs(List<Vertex> forest) {
        for(Vertex f: forest) {
            if(!f.isVisited())
                dfs(f);
        }
    }

    public void dfs(Vertex v) {
        v.setVisited(true);
        lifo.push(v);

        while(!lifo.isEmpty()) {
            var curr = lifo.pop();
            System.out.println(curr);
            for(var node: curr.getVertexes()) {
                if(!node.isVisited()) {
                    node.setVisited(true);
                    lifo.push(node);
                }
            }
        }
    }
}
