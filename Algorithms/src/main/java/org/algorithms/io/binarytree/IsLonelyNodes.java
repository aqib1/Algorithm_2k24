package org.algorithms.io.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class IsLonelyNodes {
    public List<Integer> getLonelyNodes(TreeNode root) {
        var response = new ArrayList<Integer>();
        getLonelyNodes(root, response);
        return response;
    }

    public void getLonelyNodes(TreeNode root, List<Integer> response) {
        if(root == null)
            return;

        if((root.left == null && root.right != null)
            || (root.left != null && root.right == null)) {
            response.add(Objects.requireNonNullElseGet(root.left, () -> root.right).val);
        }

        getLonelyNodes(root.left, response);
        getLonelyNodes(root.right, response);
    }
}
