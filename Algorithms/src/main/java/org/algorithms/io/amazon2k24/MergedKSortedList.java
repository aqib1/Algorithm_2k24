package org.algorithms.io.amazon2k24;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class MergedKSortedList {
    public ListNode mergeKLists(ListNode[] kSortedLists) {
        if(Objects.isNull(kSortedLists)) return null;
        var node = new ListNode();
        var minHeap = new PriorityQueue<ListNode>(
               Comparator.comparingInt(a -> a.val)
        );
        Arrays.stream(kSortedLists)
                .filter(Objects::nonNull)
                .forEach(minHeap::offer);
        var pointer = node;
        while(!minHeap.isEmpty()) {
            var poll = minHeap.poll();
            pointer.next = poll;
            pointer = pointer.next;
            if(!Objects.isNull(poll.next)) {
                minHeap.offer(poll.next);
            }
        }

        return node.next;
    }
}

