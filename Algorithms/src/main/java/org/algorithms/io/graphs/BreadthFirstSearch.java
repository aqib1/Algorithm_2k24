package org.algorithms.io.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    public static void main(String[] args) {
        var bfs = new BreadthFirstSearch();
        var a = new Vertex("A");
        var b = new Vertex("B");
        var c = new Vertex("C");
        var d = new Vertex("D");

        a.addVertex(b);
        a.addVertex(c);
        b.addVertex(d);
        b.addVertex(c);
        bfs.bfs(a);
    }
    public void bfs(Vertex root) {
        Queue<Vertex> queue = new LinkedList<>();
        root.setVisited(true);
        queue.add(root);

        while(!queue.isEmpty()) {
            var current = queue.poll();
            System.out.println("visited vertex : "+ current.getName());
            for(var vertex: current.getVertexes()) {
                if(!vertex.isVisited()) {
                    vertex.setVisited(true);
                    queue.add(vertex);
                }
            }
        }
    }
}
