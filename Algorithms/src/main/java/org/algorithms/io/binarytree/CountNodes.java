package org.algorithms.io.binarytree;

public class CountNodes {
    // Time complexity O(n)
    // Space complexity O(n)
    public int countNodes(TreeNode root) {
        return root == null ? 0 : countNodes(root.left) + countNodes(root.right) + 1;
    }
}
