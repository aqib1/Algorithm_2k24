package org.algorithms.io.binarytree;

public class CountUniValueBTree {
    private int count;
    public int countUnivalSubtrees(TreeNode root) {
        countUni(root);
        return count;
    }

    // Time complexity O(n) and Space complexity O(n)
    private boolean countUni(TreeNode root) {
        if(root == null)
            return true;

        boolean left = countUni(root.left);
        boolean right = countUni(root.right);

        if(left && right) {
            if((root.left != null && root.val != root.left.val)
                            || (root.right != null && root.val != root.right.val)) {
                return false;
            }

            count++;
            return true;
        } else {
            return false;
        }
    }
}
