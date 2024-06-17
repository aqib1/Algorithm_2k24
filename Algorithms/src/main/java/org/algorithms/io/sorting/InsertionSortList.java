package org.algorithms.io.sorting;

import org.algorithms.io.linkedlist.ListNode;

public class InsertionSortList {
    /*
    *
    * */
    public ListNode insertionSortList(ListNode head) {
        if(head.next == null)
            return head;
        var sorted = new ListNode(Integer.MIN_VALUE);
        var nextValue = head;
        while(nextValue != null) {
            var sortPtr = sorted;
            while (sortPtr.next != null && nextValue.val >= sortPtr.next.val) {
                sortPtr = sortPtr.next;
            }

            var next = sortPtr.next;
            sortPtr.next = new ListNode(nextValue.val);
            sortPtr.next.next = next;
            nextValue = nextValue.next;
        }

        return sorted.next;
    }
}
