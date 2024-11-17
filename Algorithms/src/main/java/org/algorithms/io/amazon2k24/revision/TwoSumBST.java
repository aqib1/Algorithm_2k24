package org.algorithms.io.amazon2k24.revision;

import org.algorithms.io.tree.TreeNode;

public class TwoSumBST {
    // Time complexity = O(V * E) * O(log(N)) = O(V * E)
    // Space O(V * E) * OLog(N) = O(V * E)
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if(root1 == null)
            return false;

        if(bst(root2, target - root1.val)) {
            return true;
        }

        return twoSumBSTs(root1.left, root2, target) ||
                twoSumBSTs(root1.right, root2, target);
    }

    private boolean bst(TreeNode root2, int i) {
        if(root2 == null)
            return false;
        if(root2.val == i)
            return true;

        if(i < root2.val)
           return bst(root2.left, i);
        else
           return bst(root2.right, i);
    }
}
