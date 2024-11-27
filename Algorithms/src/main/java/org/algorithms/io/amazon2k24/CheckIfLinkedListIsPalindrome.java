package org.algorithms.io.amazon2k24;

import java.util.Scanner;

public class CheckIfLinkedListIsPalindrome {
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
            String dataLine = in.nextLine();
            String []data = dataLine.split(" ");
            SinglyLinkedListNode llist = new SinglyLinkedListNode();

            for(String d: data) {
                int llistItem = Integer.parseInt(d);

                if(llistItem == -1)
                    break;

                llist.insertNode(llistItem);
            }

            boolean result = palindrome(llist.next);
            System.out.println(result);
        }
    }

    private static boolean palindrome(SinglyLinkedListNode next) {
        SinglyLinkedListNode midNode = mid(next);
        SinglyLinkedListNode reverse = reverse(midNode);

        while(reverse != null && next != null) {
            if(reverse.data != next.data)
                return false;

            next = next.next;
            reverse = reverse.next;
        }

        return true;
    }

    private static SinglyLinkedListNode reverse(SinglyLinkedListNode midNode) {
        SinglyLinkedListNode reverse = null;
        SinglyLinkedListNode current = midNode;

        while(current != null) {
            SinglyLinkedListNode next = current.next;
            current.next = reverse;
            reverse = current;
            current = next;
        }

        return reverse;
    }

    private static SinglyLinkedListNode mid(SinglyLinkedListNode next) {
        if(next == null)
            return null;

        SinglyLinkedListNode fast = next;
        SinglyLinkedListNode slow = next;
        int count = 0;

        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            count++;
        }

        return (count % 2 == 0) ? slow.next : slow;
    }
}
