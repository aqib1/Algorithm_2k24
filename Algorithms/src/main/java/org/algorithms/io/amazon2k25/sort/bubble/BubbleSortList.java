package org.algorithms.io.amazon2k25.sort.bubble;

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

    public void sort(ListNode root) {
        if(root == null || root.next == null)
            return;

        boolean swapped;
        ListNode last = null;

        do {
            swapped = false;
            ListNode ptr = root;
            while(ptr.next != last) {
                if(ptr.val > ptr.next.val) {
                    int tmp = ptr.val;
                    ptr.val = ptr.next.val;
                    ptr.next.val = tmp;
                    swapped = true;
                }
                ptr = ptr.next;
            }
            last = ptr;
        } while (swapped);
    }
}
