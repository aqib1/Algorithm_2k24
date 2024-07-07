package org.algorithms.io.list;

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

public class InsertionSort {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(-1);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(97);
        listNode = insertionSortList(listNode);

        System.out.println(listNode);
    }

    public static ListNode insertionSortList(ListNode head) {
        // 4 -> 2 -> 1 -> 3
        var result = new ListNode(Integer.MIN_VALUE);
        var pointer = head;
        while (pointer != null) {
            var resHead = result;

            while (resHead.next != null && pointer.val >= resHead.next.val) {
                resHead = resHead.next;
            }
            var next = resHead.next;
            resHead.next = new ListNode(pointer.val);
            resHead.next.next = next;
            pointer = pointer.next;
        }

        return result.next;
    }
}
