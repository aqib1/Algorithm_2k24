package org.algorithms.io.graphs;

public class AdjacencyList {
    public static void main(String[] args) {

        var a = new Vertex("A");
        var b = new Vertex("B");
        var c = new Vertex("C");
        var d = new Vertex("D");

        a.addVertex(b);
        a.addVertex(c);
        b.addVertex(d);

       a.showVertexes();
       b.showVertexes();
    }
}
