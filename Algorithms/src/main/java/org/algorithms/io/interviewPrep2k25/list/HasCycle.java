package org.algorithms.io.interviewPrep2k25.list;

import org.algorithms.io.linkedlist.ListNode;

public class HasCycle {
    // time complexity O(N) and space O(1)
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;
        var slow = head;
        var fast = head.next;
        while(fast != null && fast.next != null) {
            if(slow == fast)
                return true;

            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
