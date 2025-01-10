package org.algorithms.io.bst;

import org.algorithms.io.tree.TreeNode;

public class LowestCommonAncestor {

    // Time complexity OLog(n)
    // Space OLog(n)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }

        if(p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if(p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        return root;
    }

    // Time complexity OLog(n)
    // Space O(1)
    public TreeNode lowestCommonAncestorIterator(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null) {
            if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else {
                return root;
            }
        }
        return null;
    }
}
