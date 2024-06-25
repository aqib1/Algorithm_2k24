package org.algorithms.io.binarytree;

public class IncreasingBST {
    private TreeNode response = new TreeNode();

    // Time complexity is O(n) where n is number of nodes
    // space complexity is O(n)
    public TreeNode increasingBST(TreeNode root) {
        var pointer = response;
        construct(root);
        return pointer.right;
    }

    private void construct(TreeNode root) {
        if(root == null)
            return;

        construct(root.left);
        response.right = new TreeNode(root.val);
        response = response.right;
        construct(root.right);
    }
}
