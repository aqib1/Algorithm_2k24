package org.algorithms.io.interviewPrep2k25.tree;

import org.algorithms.io.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BSTIteratorConstructorHeavy {
    private final Queue<Integer> fifo;
    // constructor heavy implementation
    // Time O(n) & space O(n)
    public BSTIteratorConstructorHeavy(TreeNode root) {
        this.fifo = new LinkedList<>();
        inOrder(root);
    }

    public void inOrder(TreeNode root) {
        if(root == null)
            return;
        inOrder(root.left);
        fifo.add(root.val);
        inOrder(root.right);
    }

    // Time O(1)
    public int next() {
        return fifo.poll();
    }

    // Time O(1)
    public boolean hasNext() {
        return !fifo.isEmpty();
    }
}
