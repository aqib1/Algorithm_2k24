package org.algorithms.io.queues;

public class QueueWithArray {
    private long[] data;
    private int rear;
    private int front;
    private int itemCount;

    public QueueWithArray(int size) {
        data = new long[size];
    }

    public void insert(long val) {
        if(rear == data.length) {
            rear = 0;
        }
        data[rear++] = val;
        itemCount++;
    }

    public long remove() {
        var val = data[front++];
        if(front == data.length) {
            front = 0;
        }
        itemCount--;
        return val;
    }

    public long peekFront() {
        return data[front];
    }

    public long peekRear() {
        return data[rear];
    }

    public boolean isFull() {
        return itemCount == data.length;
    }

    public boolean isEmpty() {
        return itemCount == 0;
    }

    public static void main(String[] args) {
        var queue = new QueueWithArray(5);
        for(int i = 0; i < 10; i++){
            queue.insert(i);
        }
//        System.out.println(queue.peekFront());
        while(!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }
}
