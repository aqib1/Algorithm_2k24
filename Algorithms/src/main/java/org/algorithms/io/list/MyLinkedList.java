package org.algorithms.io.list;

public class MyLinkedList {
    private Node first;
    private int size;

    public MyLinkedList() {

    }

    public boolean isEmpty() {
        return first == null;
    }

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

    public int get(int index) {
        if (isEmpty() || index >= size) {
            return -1;
        }
        var tmp = first;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.value;
    }

    public void addAtHead(int val) {
        var node = new Node(val);
        node.next = first;
        first = node;
        size++;
    }

    public void addAtTail(int val) {
        var node = new Node(val);
        var ptr = first;
        if(ptr == null) {
            first = node;
        } else {
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = node;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        var node = new Node(val);
        var head = first;
        Node previous = null;

        for (int i = 0; i < index; i++) {
            previous = head;
            head = head.next;
        }

        node.next = head;
        if (previous == null) {
            first = node;
        } else {
            previous.next = node;
        }

        size++;
    }

    public void deleteAtIndex(int index) {
        if (isEmpty() || index >= size) {
            return;
        }
        var tmp = first;
        Node previous = null;
        for (int i = 0; i < index; i++) {
            previous = tmp;
            tmp = tmp.next;
        }
        if (previous == null) {
            if (first.next != null) {
                first = first.next;
            } else first = null;
        } else {
            previous.next = tmp.next;
        }
        size--;
    }

    static class Node {
        private Node next;
        private int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        var myLinkedList = new MyLinkedList();
        myLinkedList.addAtTail(1);
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.get(0));


    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
