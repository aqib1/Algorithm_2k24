package org.algorithms.io.bst;

import org.algorithms.io.binarytree.TreeNode;

import java.util.Stack;

public class BSTIterator {
    // Space O(n)
    private final Stack<TreeNode> lifo;
    public BSTIterator(TreeNode root) {
        this.lifo = new Stack<>();
        insertLeftMost(root);
    }

    // Time complexity avg & best case O(K), worst O(n)
    private void insertLeftMost(TreeNode root) {
        while(root != null) {
            lifo.push(root);
            root = root.left;
        }
    }


    // Time complexity avg & best case O(K) worst-case O(1)
    public int next() {
        TreeNode pop = lifo.pop();
        if(pop.right != null) {
            insertLeftMost(pop.right);
        }

        return pop.val;
    }

    // O(1)
    public boolean hasNext() {
        return !lifo.isEmpty();
    }
}
