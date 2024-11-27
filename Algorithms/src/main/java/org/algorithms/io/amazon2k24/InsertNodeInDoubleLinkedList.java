package org.algorithms.io.amazon2k24;

public class InsertNodeInDoubleLinkedList {
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

    public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode llist, int data) {
        DoublyLinkedListNode current = llist;
        DoublyLinkedListNode prev = null;
        while(current != null && current.data <= data) {
            prev = current;
            current = current.next;
        }

        if(prev != null) {
            DoublyLinkedListNode next = prev.next;
            prev.next = new DoublyLinkedListNode(data);
            prev.next.next = next;
        } else {
            var c = new DoublyLinkedListNode(data);
            c.next = llist;
            return c;
        }

        return llist;
    }
}
