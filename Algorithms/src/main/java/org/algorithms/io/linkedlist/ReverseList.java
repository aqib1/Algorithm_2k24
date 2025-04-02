package org.algorithms.io.linkedlist;

public class ReverseList {
    // Time complexity O(n) space is O(1)
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode previous = null;
        var current = head;

        while(current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }
}
