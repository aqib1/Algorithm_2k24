package org.algorithms.io.recursion.bst;

import org.algorithms.io.binarytree.TreeNode;

public class InsertIntoBST {
    // time complexity OLog(N) or O(h)
    // Space complexity OLog(N) or O(h)
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)
            root = new TreeNode(val);
        else
            addChild(root, val);

        return root;
    }

    private void addChild(TreeNode root, int val) {
        if(val > root.val) {
            if (root.right == null) {
                root.right = new TreeNode(val);
            } else {
                addChild(root.right, val);
            }
        } else {
            if(root.left == null) {
                root.left = new TreeNode(val);
            } else {
                addChild(root.left, val);
            }
        }
    }
}
