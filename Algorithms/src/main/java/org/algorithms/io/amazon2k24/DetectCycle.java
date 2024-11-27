package org.algorithms.io.amazon2k24;

public class DetectCycle {
    static class Node {
        int data;
        Node next;
    }

    boolean hasCycle(Node head) {
        if(head == null)
            return false;

        Node fast = head;
        Node slow = head;

        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow)
                return true;
        }

        return false;
    }
}
