package org.algorithms.io.interviewPrep2k25.tree;

import org.algorithms.io.tree.TreeNode;

import java.util.ArrayList;

public class InOrderSuccessorWithAdditionalSpace {
    // Time complexity O(2n) and space O(2n)
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        var inorder = new ArrayList<TreeNode>();
        inorder(root, inorder);
        for(int i = 0; i < inorder.size() - 1; i++) {
            if(inorder.get(i) == p)
                return inorder.get(i + 1);
        }
        return null;
    }

    private void inorder(TreeNode root, ArrayList<TreeNode> inorder) {
        if(root == null)
            return;
        inorder(root.left, inorder);
        inorder.add(root);
        inorder(root.right, inorder);
    }
}
