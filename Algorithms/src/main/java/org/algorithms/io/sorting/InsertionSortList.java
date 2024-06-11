package org.algorithms.io.sorting;

import org.algorithms.io.linkedlist.ListNode;

import java.util.ArrayList;

public class InsertionSortList {
    // Time O(n)2
    // Space O(n)
    public ListNode anotherWay(ListNode head) {
        var data = new ArrayList<Integer>();
        while(head != null) {
            data.add(head.val);
            head = head.next;
        }

        insertionSort(data);

        var response = new ListNode(0);
        var ptr = response;
        for(var d : data) {
            ptr.next = new ListNode(d);
            ptr = ptr.next;
        }
        return response.next;
    }

    private void insertionSort(ArrayList<Integer> data) {
        for(int i = 1; i < data.size(); i++) {
            int key = data.get(i);
            int j = i - 1;
            while(j >= 0 && key <= data.get(j)) {
                data.set(j + 1, data.get(j));
                j--;
            }
            data.set(j + 1, key);
        }
    }

    /*
    * Time complexity O(n)2 + Space O(1)
    * */
    public ListNode insertionSortList(ListNode head) {
        if(head.next == null)
            return head;
        var dummy = new ListNode(Integer.MIN_VALUE);
        var current = head;

        while(current != null) {
            var prev = dummy;
            while(prev.next != null && prev.next.val < current.val) {
                prev = prev.next;
            }

            var next = current.next;
            current.next = prev.next;
            prev.next = current;
            current = next;
        }

        return dummy.next;
    }
}
