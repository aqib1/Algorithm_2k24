package org.algorithms.io.amazon2k25.sort.mergeSort;

import org.algorithms.io.linkedlist.ListNode;

public class MergeSortList {
    // Time complexity ON(logN) and Space O(n)
    public static void main(String[] args) {
        var merge = new MergeSortList();
        var head = new ListNode(9);
        head.next = new ListNode(13);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(-7);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(0);

        System.out.println(
                merge.mergeSort(head)
        );
    }

    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode mid = mid(head);
        ListNode nextToMid = mid.next;
        mid.next = null; // make mid half

        var left = mergeSort(head);
        var right = mergeSort(nextToMid);

        return merge(left, right);
    }

    private ListNode merge(ListNode first, ListNode second) {
        var dummy = new ListNode(Integer.MIN_VALUE);
        var current = dummy;

        while (first != null && second != null) {
            if (first.val <= second.val) {
                current.next = first;
                first = first.next;
            } else {
                current.next = second;
                second = second.next;
            }
            current = current.next;
        }

        if (first != null) current.next = first;
        if (second != null) current.next = second;

        return dummy.next;
    }

    private ListNode mid(ListNode head) {
        if (head == null) return head;

        ListNode slow = head;
        ListNode fast = head;

        // Move fast pointer two steps and slow pointer one step at a time
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
