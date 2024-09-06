package org.algorithms.io.queues;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {

    private Queue<Integer> queue;

    public RecentCounter() {
        this.queue = new LinkedList<>();
    }

    // time complexity O(n), space complexity O(n)
    public int ping(int t) {
        if (queue.isEmpty()) {
            queue.add(t);
            return 1;
        } else {
            if (t > 3000) {
                int margin = t - 3000;
                while (!queue.isEmpty() && queue.peek() < margin) {
                    queue.poll();
                }
            }
            queue.add(t);
            return queue.size();
        }
    }
}
