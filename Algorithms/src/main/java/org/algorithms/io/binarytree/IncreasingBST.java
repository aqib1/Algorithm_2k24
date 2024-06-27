package org.algorithms.io.binarytree;

public class IncreasingBST {
    private TreeNode response = new TreeNode();

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
