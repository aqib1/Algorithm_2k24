package org.algorithms.io.bst;

import org.algorithms.io.binarytree.TreeNode;

public class PredecessorOfBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return successor(root, p, null);
    }

    public TreeNode predecessor(TreeNode root, TreeNode p) {
        TreeNode predecessor = null;
        while(root != null) {
            if(p.val <= root.val) {
                root = root.left;
            } else {
                predecessor = root;
                root = root.right;
            }
        }
        return predecessor;
    }

    public TreeNode successor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while(root != null) {
            if(p.val >= root.val) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }

    public TreeNode successor(TreeNode root, TreeNode p, TreeNode successor) {
        if(root == null)
            return successor;
        if(p.val >= root.val)
            return successor(root.right, p, successor);
        return successor(root.left, p, root);
    }
}
