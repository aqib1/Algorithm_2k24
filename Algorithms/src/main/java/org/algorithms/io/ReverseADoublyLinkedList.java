package org.algorithms.io;

public class ReverseADoublyLinkedList {
    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static DoublyLinkedListNode reverse(DoublyLinkedListNode llist) {
        // Write your code here
        DoublyLinkedListNode current = llist;
        DoublyLinkedListNode reverse = null;

        while(current != null) {
            DoublyLinkedListNode next = current.next;
            if(reverse == null) {
                current.next = reverse;
            } else {
                current.next = reverse;
                reverse.prev = current;
            }
            reverse = current;
            current = next;
        }

        return reverse;
    }
}
