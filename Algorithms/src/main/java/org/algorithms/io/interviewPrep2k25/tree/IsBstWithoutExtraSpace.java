package org.algorithms.io.interviewPrep2k25.tree;

import org.algorithms.io.tree.TreeNode;

public class IsBstWithoutExtraSpace {

    // Time complexity O(n) and space O(n)
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode root, long low, long high) {
        if(root == null)
            return true;

        if(low >= root.val || high <= root.val)
            return false;

        return isValid(root.left, low, root.val)
                    && isValid(root.right, root.val, high);
    }
}
