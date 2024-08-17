package org.algorithms.io.amazon2k24;

import java.util.*;

public class RunningMedian {
    private static final Queue<Integer> MIN_HEAP = new PriorityQueue<>();
    private static final Queue<Integer> MAX_HEAP = new PriorityQueue<>(Comparator.reverseOrder());

    public static List<Double> runningMedian(List<Integer> a) {
        List<Double> response = new ArrayList<>();

        for (int i : a) {
            addNumber(i);
            response.add(getMedian());
        }

        return response;

    }

    public static void addNumber(int i) {
        MAX_HEAP.offer(i);
        MIN_HEAP.offer(MAX_HEAP.poll());
        if (MIN_HEAP.size() > MAX_HEAP.size()) {
            MAX_HEAP.offer(MIN_HEAP.poll());
        }
    }

    public static double getMedian() {
        if (!MIN_HEAP.isEmpty() && MIN_HEAP.size() == MAX_HEAP.size()) {
            return (MIN_HEAP.peek() + MAX_HEAP.peek()) / 2.0;
        } else if (MIN_HEAP.size() > MAX_HEAP.size()) {
            return MIN_HEAP.peek();
        } else if (MAX_HEAP.size() > MIN_HEAP.size()) {
            return MAX_HEAP.peek();
        }

        return -1;
    }
}
