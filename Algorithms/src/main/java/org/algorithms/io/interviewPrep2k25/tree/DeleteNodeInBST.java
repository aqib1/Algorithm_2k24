package org.algorithms.io.interviewPrep2k25.tree;

import org.algorithms.io.tree.TreeNode;

public class DeleteNodeInBST {
    // Time complexity O(n) and space O(n)
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;
        if(key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if(key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if(root.left == null && root.right == null) {
                root = null;
            } else if(root.right != null) {
                var successor = root.val = successor(root);
                root.right = deleteNode(root.right, successor);
            } else {
                var predecessor = root.val = predecessor(root);
                root.left = deleteNode(root.left, predecessor);
            }
        }

        return root;
    }

    public int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) root = root.right;
        return root.val;
    }

    public int successor(TreeNode root) {
        root = root.right;
        while(root.left != null) root = root.left;
        return root.val;
    }
}
