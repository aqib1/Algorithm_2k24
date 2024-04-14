package org.algorithms.io.amazon2k25.random;

import org.algorithms.io.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversalBT {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(levelOrder(root));
    }

    // Time complexity O(N) where N is number of nodes in tree and space O(N)
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> response = new ArrayList<>();
        preOrder(root, 0, response);
        return response;
    }

    public static void preOrder(TreeNode root, int height, List<List<Integer>> res) {
        if(root == null)
            return;

        if(res.size() == height)
            res.add(new ArrayList<>());

        res.get(height).add(root.val);

        preOrder(root.left, height + 1, res);
        preOrder(root.right, height + 1, res);
    }

}
