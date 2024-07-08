package org.algorithms.io.binarytree;

import java.util.Objects;

public class HasPathSum {
    // Time complexity O(n) where n is nodes
    // Space complexity O(n)
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (Objects.isNull(root))
            return false;

        targetSum -= root.val;

        if (Objects.isNull(root.left) && Objects.isNull(root.right) && targetSum == 0)
            return true;

        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }

//    public boolean hasPathSum(TreeNode root, int currentSum, int targetSum) {
//        if(root == null)
//            return false;
//
//        currentSum += root.val;
//
//        if(root.left == null && root.right == null && currentSum == targetSum)
//            return true;
//
//        return hasPathSum(root.left, currentSum, targetSum) ||
//                hasPathSum(root.right, currentSum, targetSum);
//    }

}
