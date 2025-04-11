package org.algorithms.io.interviewPrep2k25.tree;

import org.algorithms.io.tree.TreeNode;

public class InOrderSuccessorWithoutExtraSpace {
    // Time complexity O(n) and space O(n)
    public static void main(String[] args) {
        var i = new InOrderSuccessorWithoutExtraSpace();
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(3);
        TreeNode p = new TreeNode(2);

        System.out.println(
                i.inorderSuccessor(root, p)
        );
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return successor(root, p);
    }

    public TreeNode successor(TreeNode root, TreeNode p) {
        TreeNode succssor = root.right;

        while (root != null) {
            if (p.val >= root.val) {
                root = root.right;
            } else {
                succssor = root;
                root = root.left;
            }
        }

        return succssor;
    }
}
