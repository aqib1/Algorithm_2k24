package org.algorithms.io.binarytree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> response = new ArrayList<>();

        pathSum(root, targetSum, new ArrayList<Integer>(), response);

        return response;
    }

    public void pathSum(TreeNode root, int targetSum, ArrayList<Integer> current, List<List<Integer>> response) {
        if(root == null) {
            return;
        }

        current.add(root.val);
        targetSum -= root.val;
        if(targetSum == 0 && root.left == null && root.right == null) {
            response.add(new ArrayList<>(current));
        }

        pathSum(root.left, targetSum, current, response);
        pathSum(root.right, targetSum, current, response);
        current.removeLast();
    }
}
