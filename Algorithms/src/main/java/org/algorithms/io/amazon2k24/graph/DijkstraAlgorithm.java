package org.algorithms.io.amazon2k24.graph;

import java.util.HashSet;
import java.util.LinkedList;

public class DijkstraAlgorithm {

    public static Graph calculateShortestPathUsingDijkstra(Graph graph, Node source) {
        source.setDistance(0);
        var settled = new HashSet<Node>();
        var unsettled = new HashSet<Node>();

        unsettled.add(source);

        while(!unsettled.isEmpty()) {
            Node currentNode = getLowestDistanceNode(unsettled);
            unsettled.remove(currentNode);
            for(var entry: currentNode.getNodesEdge().entrySet()) {
                var adjacentNode = entry.getKey();
                var edgeWeight = entry.getValue();
                if(!settled.contains(adjacentNode)) {
                    calculateMinimumDistance(currentNode, adjacentNode, edgeWeight);
                    unsettled.add(adjacentNode);
                }
            }

            settled.add(currentNode);
        }

        return graph;
    }

    private static void calculateMinimumDistance(Node currentNode, Node adjacentNode, Double edgeWeight) {
        var currentDistance = currentNode.getDistance();
        if(currentDistance + edgeWeight < adjacentNode.getDistance()) {
            adjacentNode.setDistance(currentDistance + edgeWeight);
            var shortestPath = currentNode.getShortestPath();
            shortestPath.add(currentNode);
            adjacentNode.setShortestPath(new LinkedList<>(shortestPath));
        }
    }

    private static Node getLowestDistanceNode(HashSet<Node> unsettled) {
        Node lowestDistanceNode = null;
        double minimumDistance = Double.MAX_VALUE;

        for(Node node: unsettled) {
            if(node.getDistance() < minimumDistance) {
                minimumDistance = node.getDistance();
                lowestDistanceNode = node;
            }
        }

        return lowestDistanceNode;
    }
}
