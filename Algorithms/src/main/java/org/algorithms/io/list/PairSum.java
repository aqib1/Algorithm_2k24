package org.algorithms.io.list;

import java.util.LinkedList;
import java.util.Queue;

public class PairSum {
    // Time complexity O(3Log(n)) = O(Log(n))
    // Space complexity O(1)
    public int pairSumOptimal(ListNode head) {
        if (head == null)
            return 0;
        if (head.next == null)
            return head.val;

        var slow = head;
        var fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        var reversed = reverseList(slow);
        int max = Integer.MIN_VALUE;
        var pointer = head;
        while (reversed != null) {
            max = Math.max(max, pointer.val + reversed.val);
            pointer = pointer.next;
            reversed = reversed.next;
        }

        return max;

    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode previous = null;
        var current = head;

        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }


    // Time O(n)
    // Space O(n)
    public int pairSum(ListNode head) {
        if (head == null)
            return 0;
        if (head.next == null)
            return head.val;

        int size = 0;
        var pointer = head;
        while (pointer != null) {
            pointer = pointer.next;
            size++;
        }
        int mid = size / 2;

        Queue<Integer> fifo = new LinkedList<>();
        var lifo = new LinkedList<Integer>();

        pointer = head;
        for (int i = 0; i < size; i++) {
            if (i < mid) {
                fifo.add(pointer.val);
            } else {
                lifo.push(pointer.val);
            }

            pointer = pointer.next;
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < mid; i++) {
            max = Math.max(max, fifo.poll() + lifo.pop());
        }

        return max;
    }
}
