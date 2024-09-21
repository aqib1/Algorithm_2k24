package org.algorithms.io.list;

import java.util.LinkedList;
import java.util.Queue;

public class PairSum {
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
