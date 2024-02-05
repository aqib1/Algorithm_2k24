package org.algorithms.io.binarytree;

public class FindDepthOfBTUsingTopDown {
    private int depth;
    public int maxDepth(TreeNode root) {
        return findUsingBottomUp(root, 0);
    }

    // Time complexity O(n)
    // Space complexity O(n)
    private int findUsingBottomUp(TreeNode root, int depth) {
        if(root == null)
            return depth;

        return Math.max(
                findUsingBottomUp(root.left, depth),
                findUsingBottomUp(root.right, depth)
        ) + 1;
    }

    // Time complexity O(n)
    // Space complexity O(n)
    private void findDepthUsingTopDown(TreeNode root, int depth) {
        if(root == null)
            return;
        if(root.left == null && root.right == null) {
            this.depth = Math.max(this.depth, depth);
        }
        findDepthUsingTopDown(root.left, depth + 1);
        findDepthUsingTopDown(root.right, depth + 1);
    }
}
