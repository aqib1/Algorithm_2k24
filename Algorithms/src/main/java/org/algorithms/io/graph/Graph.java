package org.algorithms.io.graph;

import java.util.*;

class Node {
    private String name;
    private double distance = Double.MAX_VALUE; // infinity
    private final Map<Node, Double> nodesEdge = new HashMap<>();
    private List<Node> shortestPath = new LinkedList<>();

    public void addEdge(Node adjacentNode, Double distance) {
        nodesEdge.put(adjacentNode, distance);

    }

    public void setShortestPath(List<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Map<Node, Double> getNodesEdge() {
        return nodesEdge;
    }

    public double getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }



    public List<Node> getShortestPath() {
        return shortestPath;
    }
}

public class Graph {
    private final List<Node> nodes;

    public Graph(List<Node> nodes) {
        this.nodes = nodes;

    }

    public List<Node> getNodes() {
        return nodes;
    }
}
