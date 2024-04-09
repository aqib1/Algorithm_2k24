package org.algorithms.io.amazon2k25.binaryTree;

import org.algorithms.io.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderUsingRecursion {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> response = new ArrayList<>();
        dfs(0, root, response);
        return response;
    }

    public void dfs(int level, TreeNode root, List<List<Integer>> response) {
        if(root == null)
            return;

        // add a new ArrayList for each level
        if(response.size() == level) {
            response.add(new ArrayList<>());
        }

        response.get(level).add(root.val);

        dfs(level + 1, root.left, response);
        dfs(level + 1, root.right, response);
    }
}
