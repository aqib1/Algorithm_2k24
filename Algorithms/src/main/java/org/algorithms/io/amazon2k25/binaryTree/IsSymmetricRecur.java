package org.algorithms.io.amazon2k25.binaryTree;

import org.algorithms.io.tree.TreeNode;

public class IsSymmetricRecur {
    // Before starting:
    // QQ: can a root be null? if yes then is that symmetric?
    // QQ: Can a root without child ?  if yes then is that symmetric?

    // Time complexity O(N) where N is number of nodes
    // Space complexity O(N) where N is number of nodes
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return false;

        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null)
            return true;

        if(left == null || right == null)
            return false;

        if(left.val != right.val)
            return false;

        return isSymmetric(left.right, right.left) &&
                    isSymmetric(left.left, right.right);
    }
}
