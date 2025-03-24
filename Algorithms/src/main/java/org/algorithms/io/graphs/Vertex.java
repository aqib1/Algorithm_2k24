package org.algorithms.io.graphs;

import java.util.*;

public class Vertex {
    private int weight;
    private String name;
    private boolean visited;
    private List<Vertex> vertexes;

    public Vertex(String name) {
        this.name = name;
        this.vertexes = new ArrayList<>();
    }

    public List<Vertex> getVertexes() {
        return vertexes;
    }

    public void addVertex(Vertex vertex) {
        Objects.requireNonNull(vertex);
        vertexes.add(vertex);
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
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

    public void showVertexes() {
        System.out.println(this + " -> "+ vertexes);
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
