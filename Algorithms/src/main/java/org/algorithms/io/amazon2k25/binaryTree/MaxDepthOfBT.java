package org.algorithms.io.amazon2k25.binaryTree;

import org.algorithms.io.tree.TreeNode;

public class MaxDepthOfBT {

    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        maxDepthUsingTailRecursion(root, 1);
        return max;
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

    // Time complexity O(N) and space O(N)
    int max = Integer.MIN_VALUE;
    public void maxDepthUsingTailRecursion(TreeNode root, int depth) {
        if(root == null)
            return;

        if(root.left == null && root.right == null)
            max = Math.max(max, depth);

        maxDepthUsingTailRecursion(root.left, depth + 1);
        maxDepthUsingTailRecursion(root.right, depth + 1);
    }
}
