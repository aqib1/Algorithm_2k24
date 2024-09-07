package org.algorithms.io.linkedlist;

import java.util.HashSet;

public class ModifiedList {

    public static void main(String[] args) {
        int[] nums = {10};
        var head = new ListNode(2);
        head.next = new ListNode(10);
        head.next.next = new ListNode(10);
        head.next.next.next = new ListNode(9);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(9);

        var h = modifiedList(nums, head);
        while(h != null) {
            System.out.print(h.val + " ");
            h = h.next;
        }
    }

    public static ListNode modifiedList(int[] nums, ListNode head) {
        var unique = new HashSet<Integer>();
        for (int num : nums) {
            unique.add(num);
        }

        var dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;

        var current = dummy; var previous = dummy;

        while(current != null) {
            var nextNode = current.next;
            if(unique.contains(current.val)) {
                previous.next = nextNode;
            } else {
               previous = current;
            }
            current = nextNode;
        }

        return dummy.next;
    }
}
