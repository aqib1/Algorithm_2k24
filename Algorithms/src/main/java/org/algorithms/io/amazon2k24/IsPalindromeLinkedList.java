package org.algorithms.io.amazon2k24;

public class IsPalindromeLinkedList {
    public static void main(String[] args) {
        var is = new IsPalindromeLinkedList();
        // 1,0,3,4,0,1
        var node = new ListNode(1);
        node.next = new ListNode(0);
        node.next.next = new ListNode(1);
//        node.next.next.next = new ListNode(1);
//        node.next.next.next.next = new ListNode(0);
//        node.next.next.next.next.next = new ListNode(1);

        System.out.println(is.isPalindrome(node));
    }
    public boolean isPalindrome(ListNode head) {
        var firstHalf = firstHalf(head);
        var reverse = reverse(firstHalf);

        while(reverse != null && head != null) {
            if(head.val != reverse.val)
                return false;
            reverse = reverse.next;
            head = head.next;
        }

        return true;
    }

    public ListNode firstHalf(ListNode head) {
        if(head.next == null || head.next.next == null)
            return head;
        var count = 0;
        var slow = head;
        var fast = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            count++;
        }
        return (count % 2 == 0) ? slow.next : slow;
    }

    public ListNode reverse(ListNode head) {
        var current = head;
        ListNode prev = null;

        while(current != null) {
            var next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

}
