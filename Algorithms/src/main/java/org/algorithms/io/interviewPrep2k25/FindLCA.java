package org.algorithms.io.interviewPrep2k25;

import org.algorithms.io.tree.TreeNode;

public class FindLCA {
    public static void main(String[] args) {

    }
    // Time complexity O(n) and space O(1)
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        if(p.val > root.val && q.val > root.val) {
           return lowestCommonAncestor(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }
}
