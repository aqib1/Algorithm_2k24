package org.algorithms.io.graphs;

import java.util.*;

class Vertex {
    private int weight;
    private String name;

    public Vertex(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex vertex = (Vertex) o;
        return weight == vertex.weight && name.equals(vertex.name);
    }

    @Override
    public int hashCode() {
        int result = weight;
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "weight=" + weight +
                ", name='" + name + '\'' +
                '}';
    }
}

class Graph {
    private final Map<Vertex, List<Vertex>> adjacencyMetrics;
    public Graph() {
        this.adjacencyMetrics = new HashMap<>();
    }

    public void addVertex(Vertex key, Vertex vertex) {
        Objects.requireNonNull(vertex);
        if(!adjacencyMetrics.containsKey(key))
            adjacencyMetrics.put(key, new ArrayList<>());

        adjacencyMetrics.get(key).add(vertex);
    }

    public void showGraph() {
        for(Vertex node: adjacencyMetrics.keySet()) {
            System.out.println(node + " -> " +adjacencyMetrics.get(node));
        }
    }
}
public class AdjacencyList {
    public static void main(String[] args) {
        var graph = new Graph();

        var a = new Vertex("A");
        var b = new Vertex("B");
        var c = new Vertex("C");
        var d = new Vertex("D");

        graph.addVertex(a, b);
        graph.addVertex(a, c);
        graph.addVertex(b, d);

        graph.showGraph();
    }
}
