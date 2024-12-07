package org.algorithms.io.sorting;

import org.algorithms.io.linkedlist.ListNode;

public class InsertionSortList {
    /*
    * Time complexity O(n)2 + Space O(1)
    * */
    public ListNode insertionSortList(ListNode head) {
        if(head.next == null)
            return head;
        var dummy = new ListNode(Integer.MIN_VALUE);
        var current = head;

        while(current != null) {
            var prev = dummy;
            while(prev.next != null && prev.next.val < current.val) {
                prev = prev.next;
            }

            var next = current.next;
            current.next = prev.next;
            prev.next = current;
            current = next;
        }

        return dummy.next;
    }
}
