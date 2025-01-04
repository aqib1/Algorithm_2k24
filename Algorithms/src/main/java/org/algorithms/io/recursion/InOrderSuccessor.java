package org.algorithms.io.recursion;

import org.algorithms.io.binarytree.TreeNode;

public class InOrderSuccessor {
    // Time complexity O(n);
    // Space complexity OLog(n); due to BST
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return inOrder(root, p, null);
    }

    private TreeNode inOrder(TreeNode root, TreeNode p, TreeNode successor) {
        if(root == null)
            return successor;
        if(p.val >= root.val)
            return inOrder(root.right, p, successor);
        return inOrder(root.left, p, root);
    }
}
