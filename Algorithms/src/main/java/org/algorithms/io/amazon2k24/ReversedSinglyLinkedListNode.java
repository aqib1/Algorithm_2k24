package org.algorithms.io.amazon2k24;

import org.algorithms.io.list.SingleLinkedList;

public class ReversedSinglyLinkedListNode {
    public static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        public SinglyLinkedListNode() {

        }
        public SinglyLinkedListNode(
                SinglyLinkedListNode next,
                int data
        ) {
            this.next = next;
            this.data = data;
        }
    }

    public static SinglyLinkedListNode reverse(SinglyLinkedListNode list) {
        SinglyLinkedListNode current = list;
        SinglyLinkedListNode reverse = null;

        while(current != null) {
            SinglyLinkedListNode next = current.next;
            current.next = reverse;
            reverse = current;
            current = next;
        }

        return reverse;
    }

}
