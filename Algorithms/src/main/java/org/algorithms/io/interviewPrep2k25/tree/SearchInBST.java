package org.algorithms.io.interviewPrep2k25.tree;

import org.algorithms.io.tree.TreeNode;

public class SearchInBST {
    // Time complexity OLog(n) and space OLog(n)
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null || root.val == val)
            return root;

        if(val > root.val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }
}
