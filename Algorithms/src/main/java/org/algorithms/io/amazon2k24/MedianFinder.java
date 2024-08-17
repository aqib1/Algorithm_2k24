package org.algorithms.io.amazon2k24;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {

    // [1]
    // max[1]
    // min[1] , max[]
    // min > max = max[1], min[]
    // [2]
    // max[2, 1]
    // min [2] , max[1]
    // min > max ? no
    // [3]
    // max[3, 1]
    // min[2, 3] = max[1]
    // min > max = max[2, 1], min[3]

    // rules min ~ == max
    // if min === max => min.top + max.top / 2.0
    // if min > max return min.top
    // if max > min return max.top
    // return -1.0 // both are empty



    private final Queue<Integer> maxHeap;
    private final Queue<Integer> minHeap;

    public MedianFinder() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if(minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (!maxHeap.isEmpty() && maxHeap.size() == minHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            if (maxHeap.size() > minHeap.size())
                return maxHeap.peek();
            else if (minHeap.size() > maxHeap.size())
                return minHeap.peek();
        }

        return -1;
    }

    public static void main(String[] args) {
        var m = new MedianFinder();
        System.out.println(m.findMedian());
        m.addNum(1);
        System.out.println(m.findMedian());
        m.addNum(2);
        System.out.println(m.findMedian());
        m.addNum(3);
        System.out.println(m.findMedian());
    }
}
