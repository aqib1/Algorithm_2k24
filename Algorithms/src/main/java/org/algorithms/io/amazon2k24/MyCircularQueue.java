package org.algorithms.io.amazon2k24;

public class MyCircularQueue {
    public static void main(String[] args) {
        var cq = new MyCircularQueue(3);
        System.out.println(cq.enQueue(1));
        System.out.println(cq.enQueue(2));
        System.out.println(cq.enQueue(3));
        System.out.println(cq.enQueue(4));
        System.out.println(cq.Rear());
        System.out.println(cq.isFull());
        System.out.println(cq.deQueue());
        System.out.println(cq.enQueue(4));
        System.out.println(cq.Rear());
        System.out.println(cq.Front());

    }

    private final int []queue;
    private int front;
    private int rare;
    private int size;

    // Space complexity O(k)
    public MyCircularQueue(int k) {
        this.queue = new int[k];
        this.rare = -1;
    }

    // time complexity O(1)
    public boolean enQueue(int value) {
        if(isFull()) return false;

        rare = (rare + 1) % queue.length;
        this.queue[rare] = value;
        size++;
        return true;
    }

    // time complexity O(1)
    public boolean deQueue() {
        if(isEmpty()) return false;

        front = (front + 1) % queue.length;
        size--;
        return true;
    }

    // time complexity O(1)
    public int Front() {
        return isEmpty() ? -1 : this.queue[front];
    }

    // time complexity O(1)
    public int Rear() {
        return isEmpty() ? -1 : this.queue[rare];
    }

    // time complexity O(1)
    public boolean isEmpty() {
        return size == 0;
    }

    // time complexity O(1)
    public boolean isFull() {
        return size == queue.length;
    }
}
