package org.algorithms.io.deque;

import java.util.ArrayDeque;

public class DequeUsingArray {
    private Integer[] data;
    private transient int head;
    private transient int tail;
    private int size;

    public DequeUsingArray(int limit) {
        data = new Integer[limit];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size >= data.length;
    }

    public void add(int value) {
        addLast(value);
    }

    public void addFirst(int value) {
        if(isFull()) {
            throw new IllegalArgumentException("Deque is full");
        }
        final Integer[] elements = data;
        elements[head = dec(head, elements.length)] = value;
        size++;
    }

    public void addLast(int value) {
        if(isFull()) {
            throw new IllegalArgumentException("Deque is full");
        }
        final Integer[] elements = data;
        elements[tail] = value;
        tail = inc(tail, elements.length);
        size++;
    }

    public Integer removeFirst() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Deque is already empty");
        }
        size--;
        final Integer[] elements = data;
        Integer e = elements[head];
        if(e != null) {
            elements[head] = null;
            head = inc(head, elements.length);
        }
        return e;
    }

    public Integer removeLast() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Deque is already empty");
        }
        size--;
        final Integer[] elements = data;
        final int t = dec(tail, elements.length);
        Integer e = elements[t];
        if(e != null) {
            elements[tail = t] = null;
        }
        return e;
    }

    public int inc(int i, int limit) {
        if(++i >= limit) i = 0;
        return i;
    }

    public int dec(int i, int limit) {
        if(--i < 0) i = limit - 1;
        return i;
    }

    @Override
    public String toString() {
        var toStr = new StringBuilder();
        int start = head;
        for (int x = 0; x < size; x++) {
            toStr.append(data[start]).append(" ");
            start = inc(start, data.length);
        }

        return toStr.toString();
    }

    public static void main(String[] args) {
        var deque  = new DequeUsingArray(100);
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addLast(4);
        deque.addLast(5);
        deque.addFirst(0);

        System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());

        System.out.println(deque);
    }
}
