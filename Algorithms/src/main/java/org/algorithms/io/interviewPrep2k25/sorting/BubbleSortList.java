package org.algorithms.io.interviewPrep2k25.sorting;

import org.algorithms.io.linkedlist.ListNode;

public class BubbleSortList {
    public static void main(String[] args) {
        var b = new BubbleSortList();
        var head = new ListNode(19);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(-3);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(0);

        b.sort(head);
        System.out.println(head);
    }

    public void sort(ListNode head) {
        if(head == null || head.next == null)
            return;

        boolean swapped;
        ListNode end = null;
        do {
            swapped = false;
            ListNode ptr = head;

            while (ptr.next != end) {
                if(ptr.val > ptr.next.val) {
                    int tmp = ptr.val;
                    ptr.val = ptr.next.val;
                    ptr.next.val = tmp;
                    swapped = true;
                }
                ptr = ptr.next;
            }

            end = ptr;
        } while (swapped);
    }
}
