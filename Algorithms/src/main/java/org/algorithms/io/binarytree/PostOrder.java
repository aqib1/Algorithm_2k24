package org.algorithms.io.binarytree;

import java.util.ArrayList;
import java.util.List;

public class PostOrder {

    // Time complexity O(n)
    // Space complexity O(n)
    public List<Integer> postorderTraversal(TreeNode root) {
        var postorder = new ArrayList<Integer>();
        postorderResult(root, postorder);
        return postorder;
    }

    public void postorderResult(TreeNode root, List<Integer> postorder) {
        if(root == null)
            return;

        postorderResult(root.left, postorder);
        postorderResult(root.right, postorder);
        postorder.add(root.val);
    }
}
