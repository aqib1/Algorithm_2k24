package org.algorithms.io.amazon2k24.revision;

import java.util.Scanner;

public class DetectCycleInSinglyLinkedList {
    public static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        public SinglyLinkedListNode() {

        }

        public SinglyLinkedListNode(int data) {
            this.data = data;
        }

        public void insertNode(int data) {
            SinglyLinkedListNode current = this;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new SinglyLinkedListNode(data);
        }
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int tests = Integer.parseInt(in.nextLine());

            for (int testsItr = 0; testsItr < tests; testsItr++) {
                int index = Integer.parseInt(in.nextLine());
                SinglyLinkedListNode llist = new SinglyLinkedListNode();
                int llistCount = Integer.parseInt(in.nextLine());

                for (int i = 0; i < llistCount; i++) {
                    int llistItem = Integer.parseInt(in.nextLine());
                    llist.insertNode(llistItem);
                }

                SinglyLinkedListNode extra = new SinglyLinkedListNode(-1);
                SinglyLinkedListNode temp = llist.next;

                for (int i = 0; i < llistCount; i++) {
                    if (i == index) {
                        extra = temp;
                    }

                    if (i != llistCount - 1) {
                        temp = temp.next;
                    }
                }

                temp.next = extra;
                boolean result = hasCycle(llist.next);
                System.out.println((result ? 1 : 0));
            }
        }
    }

    private static boolean hasCycle(SinglyLinkedListNode next) {
        if(next == null)
            return false;

        SinglyLinkedListNode slow = next;
        SinglyLinkedListNode fast = next;

        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast)
                return true;
        }

        return false;
    }
}
