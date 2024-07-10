package org.algorithms.io.queues;

class Node {
    int value;
    Node next;

    public Node() {

    }

    public Node(int value, Node next) {
        this(value);
        this.next = next;
    }

    public Node(int value) {
        this.value = value;
    }
}

public class QueueWithNode {
    private Node front;
    private Node end;
    public int size;

    public void insert(int value) {
        var node = new Node(value);
        if (front == null) front = node;
        if (end == null) end = node;
        else {
            end.next = node;
            end = end.next;
        }
        size++;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return size;
    }

    public int remove() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        int value = front.value;
        front = front.next;
        size--;
        return value;
    }

    public int peekFirst() {
        return front.value;
    }


    public static void main(String[] args) {
        var queue = new QueueWithNode();
        queue.insert(1);
        queue.insert(5);
        queue.insert(11);
        queue.insert(-1);

        System.out.println(queue.peekFirst());
        System.out.println();
        while(!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }
}
