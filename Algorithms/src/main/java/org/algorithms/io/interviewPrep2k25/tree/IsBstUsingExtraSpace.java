package org.algorithms.io.interviewPrep2k25.tree;

import org.algorithms.io.tree.TreeNode;

import java.util.ArrayList;

public class IsBstUsingExtraSpace {

    // time complexity O(2n) where n is number of nodes and space O(2n)
    public boolean isBstUsingExtraSpace(TreeNode root) {
        var inOrder = new ArrayList<Integer>();
        inOrder(root, inOrder);
        // A BST is sorted when inOrder
        for(int i = 0; i < inOrder.size() - 1; i++) {
            if(inOrder.get(i + 1) <= inOrder.get(i)) {
                return false;
            }
        }

        return true;
    }

    private void inOrder(TreeNode root, ArrayList<Integer> inOrder) {
        if(root == null)
            return;
        inOrder(root.left, inOrder);
        inOrder.add(root.val);
        inOrder(root.right, inOrder);
    }

}
