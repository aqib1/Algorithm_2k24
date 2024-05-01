package org.algorithms.io.amazon2k25.binaryTree;

import org.algorithms.io.tree.TreeNode;

public class HasPathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        var h  = new HasPathSum();
        System.out.println(h.hasPathSum(root, 22));
    }

    // Time complexity O(n) where n is number of nodes and space is O(n)
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        targetSum -= root.val;
        if(targetSum == 0 && root.left == null && root.right == null)
            return true;
        return hasPathSum(root.left, targetSum)
                || hasPathSum(root.right, targetSum);
    }
}
