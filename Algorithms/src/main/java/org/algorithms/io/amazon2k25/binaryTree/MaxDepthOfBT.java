package org.algorithms.io.amazon2k25.binaryTree;

import org.algorithms.io.tree.TreeNode;

public class MaxDepthOfBT {

    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }

    // Time complexity O(N) and space O(N)
    public int maxDepth(TreeNode root, int depth) {
        if(root == null)
            return depth;

        return Math.max(
                maxDepth(root.left, depth),
                maxDepth(root.right, depth)
        ) + 1;
    }
}
