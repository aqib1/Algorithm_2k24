package org.algorithms.io.binarytree;

public class DiameterOfBt {
    private int d = 0;

    // time complexity O(N) and space O(N)
    public int diameterOfBinaryTree(TreeNode root) {
        d = 0;
        find(root);
        return d;
    }

    public int find(TreeNode root) {
        if(root == null)
            return 0;

        int left = find(root.left);
        int right = find(root.right);
        d = Math.max(d, left + right);

        return Math.max(left, right) + 1;
    }
}
