package org.algorithms.io.interviewPrep2k25.sorting;

import org.algorithms.io.linkedlist.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SortLinkedList {
    public ListNode sortList(ListNode head) {
        if(head == null)
            return null;
        var minHeap = new PriorityQueue<ListNode>(
                Comparator.comparingInt(l -> l.val)
        );

        while(head != null) {
            minHeap.offer(head);
            head = head.next;
        }

        var response = minHeap.poll();
        var current = response;
        while (!minHeap.isEmpty()) {
            current.next = minHeap.peek();
            current = minHeap.poll();
        }
        current.next = null;

        return response;
    }
}
