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
    public MyCircularQueue(int k) {
        this.queue = new int[k];
        this.rare = -1;
    }

    public boolean enQueue(int value) {
        if(isFull()) return false;

        rare = (rare + 1) % queue.length;
        this.queue[rare] = value;
        size++;
        return true;
    }


    public boolean deQueue() {
        if(isEmpty()) return false;

        front = (front + 1) % queue.length;
        size--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : this.queue[front];
    }

    public int Rear() {
        return isEmpty() ? -1 : this.queue[rare];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }
}
