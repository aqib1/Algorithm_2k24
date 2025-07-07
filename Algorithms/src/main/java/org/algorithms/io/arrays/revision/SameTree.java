package org.algorithms.io.arrays.revision;

public class SameTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Time O(n) where n is number of nodes and space is O(n)
    public boolean isSameTree(TreeNode n1, TreeNode n2) {
        if(n1 == null && n2 == null) return true;
        if(n1 == null || n2 == null) return false;

        return n1.val == n2.val
                && isSameTree(n1.left, n2.left)
                && isSameTree(n1.right, n2.right);
    }
}
