package org.algorithms.io.binarytree;

public class CountNodes {
    public int countNodes(TreeNode root) {
        return root == null ? 0 : countNodes(root.left) + countNodes(root.right) + 1;
    }
}
