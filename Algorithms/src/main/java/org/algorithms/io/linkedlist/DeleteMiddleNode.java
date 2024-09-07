package org.algorithms.io.linkedlist;

public class DeleteMiddleNode {
    // 1,3,4,7,1,2,6
    public static void main(String[] args) {
        var head = new ListNode(1);
            head.next = new ListNode(3);
            head.next.next = new ListNode(4);
            head.next.next.next = new ListNode(7);
            head.next.next.next.next = new ListNode(1);
            head.next.next.next.next.next = new ListNode(2);
            head.next.next.next.next.next.next = new ListNode(6);
       deleteMiddle(head);
    }

    public static ListNode deleteMiddle(ListNode head) {
        int len = 0;
        var pointer = head;
        while (pointer != null) {
            pointer = pointer.next;
            len++;
        }

        int mid = len / 2;
        var dummy = new ListNode();
        dummy.next = head;
        var current = dummy;
        var prev = dummy;
        int i = -1;
        while (current != null) {
            var next = current.next;

            if (i == mid) {
                prev.next = next;
                break;
            } else {
                prev = current;
            }
            i++;
            current = next;
        }

        return dummy.next;
    }
}
