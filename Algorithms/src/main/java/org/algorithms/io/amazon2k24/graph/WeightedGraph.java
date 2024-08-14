package org.algorithms.io.amazon2k24.graph;

import java.util.*;

class Edge {
    private Vertex source;
    private Vertex destination;
    private int weight;

    public Edge(Vertex source, Vertex destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public Vertex getSource() {
        return source;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }

    public Vertex getDestination() {
        return destination;
    }

    public void setDestination(Vertex destination) {
        this.destination = destination;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}

class Vertex {
    private int weight;
    private final int value;

    public Vertex(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return value == vertex.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

class WGraph {
    private final Map<Vertex, List<Edge>> adjacencyMetrix;

    public WGraph() {
        this.adjacencyMetrix = new HashMap<>();
    }

    public boolean containVertex(Vertex v) {
        return adjacencyMetrix.containsKey(v);
    }

    public Vertex makeVertex(int value) {
        return new Vertex(value);
    }

    public List<Edge> getEdges(Vertex v) {
        return adjacencyMetrix.get(v);
    }

    public void addEdge(Vertex source, Vertex destination, int weight) {
        var edge = new Edge(source, destination, weight);
        var currSource = adjacencyMetrix.getOrDefault(source, new LinkedList<>());
        currSource.add(edge);
        adjacencyMetrix.put(source, currSource);
    }

    public void printGraph() {
        for (var vertex : adjacencyMetrix.keySet()) {
            List<Edge> list = adjacencyMetrix.get(vertex);
            for (int j = 0; j < list.size(); j++) {
                System.out.println("vertex-" + vertex.getValue() + " is connected to " +
                        list.get(j).getDestination() + " with weight " + list.get(j).getWeight());
            }
        }
    }
}

public class WeightedGraph {

    public static void main(String[] args) {
        var shortestPath = new WeightedGraph();
        WGraph graph = new WGraph();
        var v0 = graph.makeVertex(0);
        var v1 = graph.makeVertex(1);
        var v2 = graph.makeVertex(2);
        var v3 = graph.makeVertex(3);
        graph.addEdge(v0, v1, 4);
        graph.addEdge(v0, v3, 0);
        graph.addEdge(v3, v1, 6);
        graph.addEdge(v0, v2, 3);
        graph.addEdge(v1, v3, 10);
        graph.addEdge(v1, v2, 1);
        graph.addEdge(v2, v1, 5);
        graph.printGraph();
    }
}
