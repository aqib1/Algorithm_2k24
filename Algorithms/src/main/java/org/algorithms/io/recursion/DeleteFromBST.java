package org.algorithms.io.recursion;

import org.algorithms.io.binarytree.TreeNode;

public class DeleteFromBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null || root.val == key) {
            return null;
        } else {
            deleteChild(root, key);
        }
        return root;
    }

    private void deleteChild(TreeNode root, int key) {
        if(key > root.val && root.right != null) {
            if(key == root.right.val) {
                root.right = null;
            } else {
                deleteNode(root.right, key);
            }
        } else if(key < root.val && root.left != null) {
            if(key == root.left.val) {
                root.left = null;
            } else {
                deleteNode(root.left, key);
            }
        }
    }
}
