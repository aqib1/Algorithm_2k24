package org.algorithms.io.mockinterview;

import org.algorithms.io.linkedlist.ListNode;

public class Test {
    public static void main(String[] args) {
        var head = new ListNode(9);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(0);
        head.next.next.next.next = new ListNode(11);
        head.next.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next.next = new ListNode(16);
        System.out.println(
                insertionSortList(head)
        );
    }

    public static ListNode insertionSortList(ListNode head) {
        if(head == null)
            return null;
        var dummy = new ListNode(Integer.MIN_VALUE);
        var current = head;
        while(current != null) {
            var pre = dummy;
            while(pre.next != null && pre.next.val <= current.val) {
                pre = pre.next;
            }

            var next = current.next;
            current.next = pre.next;
            pre.next = current;
            current = next;
        }


        return dummy.next;
    }
}
