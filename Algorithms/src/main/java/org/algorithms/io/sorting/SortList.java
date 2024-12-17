package org.algorithms.io.sorting;

import org.algorithms.io.linkedlist.ListNode;

import java.util.Objects;

public class SortList {
    // Time complexity O(n)2
    // Space complexity O(1)
    public ListNode sortList(ListNode head) {
        if(Objects.isNull(head))
            return null;
        var dummy = new ListNode(Integer.MIN_VALUE);
        var current = head;

        while(current != null) {
            var previous = dummy;
            while(previous.next != null && current.val < previous.next.val) {
                previous = previous.next;
            }
            var next = current.next;
            current.next = previous.next;
            previous.next = current;
            current  = next;
        }

        return dummy.next;
    }
}
