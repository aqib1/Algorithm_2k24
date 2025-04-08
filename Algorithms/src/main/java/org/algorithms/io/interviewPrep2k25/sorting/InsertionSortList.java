package org.algorithms.io.interviewPrep2k25.sorting;

import org.algorithms.io.linkedlist.ListNode;

public class InsertionSortList {
    public static void main(String[] args) {
        var i = new InsertionSortList();
        var head = new ListNode(9);
        head.next = new ListNode(13);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(-7);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(0);

        System.out.println(i.sort(head));
    }

    public ListNode sort(ListNode head) {
        if(head == null)
            return null;
        var dummy = new ListNode(Integer.MIN_VALUE);
        var current = head;

        while(current != null) {
            var pre = dummy;
            while(pre.next != null && pre.next.val < current.val) {
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
