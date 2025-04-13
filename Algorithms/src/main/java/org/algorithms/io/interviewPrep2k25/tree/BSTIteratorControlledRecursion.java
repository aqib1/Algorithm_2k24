package org.algorithms.io.interviewPrep2k25.tree;

import org.algorithms.io.tree.TreeNode;

import java.util.Stack;

public class BSTIteratorControlledRecursion {
    private final Stack<TreeNode> lifo;

    // space O(n) where n is number of nodes
    // Time complexity O(n) where n is number of left nodes to root
    public BSTIteratorControlledRecursion(TreeNode root) {
        this.lifo = new Stack<>();
        insertLeftMost(root);
    }

    private void insertLeftMost(TreeNode root) {
        while (root != null) {
            lifo.push(root);
            root = root.left;
        }
    }

    // Time complexity O(n) where n is number of left nodes to right node
    // if there is no more right node then O(1)
    public int next() {
        var pop = lifo.pop();

        if (pop.right != null) {
            insertLeftMost(pop.right);
        }

        return pop.val;
    }

    // O(1)
    public boolean hasNext() {
        return !lifo.isEmpty();
    }
}
