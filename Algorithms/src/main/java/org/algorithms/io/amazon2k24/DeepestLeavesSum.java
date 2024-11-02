package org.algorithms.io.amazon2k24;

import org.algorithms.io.tree.TreeNode;

public class DeepestLeavesSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(7);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(8);
        var d = new DeepestLeavesSum();
        System.out.println(
                d.deepestLeavesSum(root)
        );
    }

    // Time complexity O(N) Space complexity O(N)
    private int maxDepth = Integer.MIN_VALUE;
    private int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
//        int depth = depth(root, 0);
        deepestSum(root, 0);
        return sum;
    }

//    public int depth(TreeNode root, int depth) {
//        if(root == null) return depth;
//
//        return Math.max(
//          depth(root.left, depth + 1),
//          depth(root.right, depth + 1)
//        );
//    }

    public void deepestSum(TreeNode root, int depth) {
        if(root == null)
            return;

        if(depth == maxDepth) {
            sum += root.val;
        }

        if(maxDepth < depth) {
            maxDepth = depth;
            sum = 0;
            sum += root.val;
        }

        deepestSum(root.left, depth + 1);
        deepestSum(root.right, depth + 1);
    }
}
