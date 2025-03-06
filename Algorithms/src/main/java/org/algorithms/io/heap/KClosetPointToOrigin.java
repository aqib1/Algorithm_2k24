package org.algorithms.io.heap;

import java.util.AbstractMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KClosetPointToOrigin {
    // Time complexity ONLog(N) and Space O(N)
    public int[][] kClosest(int[][] points, int k) {
        var minHeap = new PriorityQueue<Map.Entry<int[], Double>>(
                Map.Entry.comparingByValue()
        );
        var result = new int[k][2];
        for(int [] point : points) {
            // we need to find distance of each point from origin (0,0)
            var distance = Math.sqrt(
                    Math.pow(point[0], 2) + Math.pow(point[1], 2)
            );
            minHeap.offer(new AbstractMap.SimpleEntry<>(point, distance));
        }

        for(int i = 0; i < k && !minHeap.isEmpty(); i++) {
            result[i] = minHeap.poll().getKey();
        }

        return result;
    }
}
