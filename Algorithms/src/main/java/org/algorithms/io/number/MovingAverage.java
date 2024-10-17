package org.algorithms.io.number;

import java.util.ArrayDeque;
import java.util.Deque;

public class MovingAverage {

    public static void main(String[] args) {
        var movingAvg = new MovingAverage(3);
        System.out.println(movingAvg.next(1));
        System.out.println(movingAvg.next(10));
        System.out.println(movingAvg.next(3));
        System.out.println(movingAvg.next(5));
    }

    private final Deque<Integer> data;
    private final int size;
    private double sum;
    public MovingAverage(int size) {
        this.size = size;
        this.data = new ArrayDeque<>();
    }

    public double next(int val) {
        this.data.addLast(val);
        this.sum += val;
        if(this.data.size() > this.size) this.sum -= this.data.removeFirst();
        return this.sum / (double)this.data.size();
    }
}
