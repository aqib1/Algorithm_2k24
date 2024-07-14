package org.algorithms.io.list;

import java.util.EmptyStackException;


public class SingleLinkedList {
    private Node first;

    public SingleLinkedList() {
    }

    // Time complexity O(1)
    // Space complexity O(n)
    public void push(int value) {
        var node = new Node(value);
        node.next = first;
        first = node;
    }

    // Time complexity O(n)
    @Override
    public String toString() {
        var f = first;
        var builder = new StringBuilder();

        while (f != null) {
            builder.append(f.value).append(" ");
            f = f.next;
        }

        return builder.toString();
    }

    public boolean isEmpty() {
        return first == null;
    }

    // Time complexity O(1)
    public int deleteFirst() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        Node tmp = first;
        first = first.next;
        return tmp.value;
    }

    // Time complexity O(n)
    public int deleteLast() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }


        var last = first;
        Node secondLast = null;
        while (last.next != null) {
            secondLast = last;
            last = last.next;
        }

        if (secondLast == null) {
            var value = last.value;
            first = null;
            return value;
        }
        int val = last.value;
        secondLast.next = null;
        return val;
    }

    static class Node {
        private final int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        var singleLinkedList = new SingleLinkedList();
        singleLinkedList.push(1);
        singleLinkedList.push(2);
        singleLinkedList.push(3);
        singleLinkedList.push(4);

        System.out.println(singleLinkedList);

        System.out.println("Deleted: " + singleLinkedList.deleteFirst());

        System.out.println(singleLinkedList);

        System.out.println("Deleted: " + singleLinkedList.deleteLast());

        System.out.println(singleLinkedList);

        System.out.println("Deleted: " + singleLinkedList.deleteLast());

        System.out.println(singleLinkedList);

        System.out.println("Deleted: " + singleLinkedList.deleteLast());

        System.out.println(singleLinkedList);
    }
}
