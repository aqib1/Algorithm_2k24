package org.algorithms.io.binarytree;

public class SearchInBST {
    // time complexity OLog(N)
    // space complexity OLog(N)
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null)
            return null;
        if(val == root.val)
            return root;

        if(val > root.val)
            return searchBST(root.right, val);
        else
            return searchBST(root.left, val);
    }
}
