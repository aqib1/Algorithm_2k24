package org.algorithms.io.linkedlist;

/*
* Input: head = [1,2,3,4,5]
* Output: [1,3,5,2,4]
* */
public class OddEvenList {
    public static void main(String[] args) {
        var list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        list.next.next.next.next.next = new ListNode(6);
        System.out.println(
                oddEvenList(list)
        );
    }

    // Time complexity O(N) where N is number of nodes
    // Space complexity O(N)
    public static ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        var odds = new ListNode();
        var evens = new ListNode();
        var evenPointer = evens;
        var oddPointer = odds;
        var pointer = head;
        var even = false;
        while(pointer != null) {
            if(even) {
                evenPointer.next = pointer;
                evenPointer = evenPointer.next;
                even = false;
            } else {
                oddPointer.next = pointer;
                oddPointer = oddPointer.next;
                even = true;
            }
            pointer = pointer.next;
        }

        if(even)
            evenPointer.next = null;

        oddPointer.next = evens.next;

        return odds.next;
    }

    // Time complexity O(N)
    // Space complexity O(1)
    public ListNode oddEvenListWithConstantSpace(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        var oddPointer = head;
        var evenPointer = head.next;
        var evenHead = head.next;

        while(evenPointer != null && evenPointer.next != null) {
            oddPointer.next = oddPointer.next.next;
            evenPointer.next = evenPointer.next.next;
            oddPointer = oddPointer.next;
            evenPointer = evenPointer.next;
        }

        oddPointer.next = evenHead;

        return head;
    }
}
