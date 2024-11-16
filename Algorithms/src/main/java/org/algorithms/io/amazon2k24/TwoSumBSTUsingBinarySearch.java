package org.algorithms.io.amazon2k24;

import org.algorithms.io.tree.TreeNode;

public class TwoSumBSTUsingBinarySearch {

    // Time O(V + E)
    // Space O(V + E)
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if(root1 == null)
            return false;

        if(binarySearch(root2, target - root1.val)) {
            return true;
        }

        return twoSumBSTs(root1.left, root2, target) ||
                    twoSumBSTs(root1.right, root2, target);
    }

    private boolean binarySearch(TreeNode root2, int target) {
        if(root2 == null)
            return false;

        if(target == root2.val)
            return true;

        if(target > root2.val)
            return binarySearch(root2.right, target);
        else
           return binarySearch(root2.left, target);
    }
}
