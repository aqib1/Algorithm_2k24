package org.algorithms.io.amazon2k25.binaryTree;

import org.algorithms.io.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class IsSymmetricIterative {
    public static void main(String[] args) {
        var root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(5);

        System.out.println(isSymmetric(root));
    }

    /**
     * Q1: Can root be null ? if yes then is it symmetric ?
     * Q2: Can root be single node ? if yes then is it symmetric ?
     */

    // Time complexity O(n) and space complexity O(n)
    public static boolean isSymmetric(TreeNode root) {
        if (root == null)
            return false;
        Queue<TreeNode> fifo = new LinkedList<>();
        fifo.add(root);
        fifo.add(root);

        while (!fifo.isEmpty()) {
            var left = fifo.poll();
            var right = fifo.poll();

            if (left == null && right == null) continue;
            if(left == null || right == null) return false;
            if (left.val != right.val) return false;

            // adding to queue
            fifo.add(left.left);
            fifo.add(right.right);
            fifo.add(left.right);
            fifo.add(right.left);
        }

        return true;
    }
}
