package org.algorithms.io.linkedlist;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        ListNode ptr = this;
        var builder = new StringBuilder();
        while (ptr != null) {
            builder.append(ptr.val).append(" ");
            ptr = ptr.next;
        }
        builder.append("\n");
        return builder.toString();
    }
}
