package org.algorithms.io.binarytree;

public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum(root, 0, targetSum);
    }

    // Time complexity O(n) where n is nodes
    // Space complexity O(n)
    public boolean hasPathSum(TreeNode root, int currentSum, int targetSum) {
        if(root == null)
            return false;

        currentSum += root.val;

        if(root.left == null && root.right == null && currentSum == targetSum)
            return true;

        return hasPathSum(root.left, currentSum, targetSum) ||
                hasPathSum(root.right, currentSum, targetSum);
    }

}
