package org.algorithms.io.interviewPrep2k25.list;

import org.algorithms.io.linkedlist.ListNode;

public class RemoveDuplicates {
    // Time complexity O(n) and space O(1)
    public ListNode deleteDuplicates(ListNode head) {
        var pointer = head;
        while (pointer != null && pointer.next != null) {
            if (pointer.val == pointer.next.val) {
                pointer.next = pointer.next.next;
            } else {
                pointer = pointer.next;
            }
        }

        return head;
    }
}
