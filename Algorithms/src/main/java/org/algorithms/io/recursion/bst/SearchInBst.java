package org.algorithms.io.recursion.bst;

import org.algorithms.io.binarytree.TreeNode;

public class SearchInBst {
    // Time complexity O(h) where h is height of tree
    // Space complexity O(h) due to recursion
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null || root.val == val)
            return root;

        if(val > root.val)
            return searchBST(root.right, val);
        else return searchBST(root.left, val);
    }
}
