package org.algorithms.io.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class ConcatNext {
    // Time and space complexity O(n)
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null)
            return null;
        root.next = new Node(0);
        Queue<Node> bfs = new LinkedList<>();
        bfs.add(root);

        while (!bfs.isEmpty()) {
            var current = bfs.poll();
            var index = current.next.val;
            if (bfs.isEmpty() || current.next.val != bfs.peek().next.val) {
                current.next = null;
            } else {
                current.next = bfs.peek();

            }

            if (current.left != null) {
                current.left.next = new Node(index + 1);
                bfs.add(current.left);
            }

            if (current.right != null) {
                current.right.next = new Node(index + 1);
                bfs.add(current.right);
            }
        }

        return root;
    }
}
