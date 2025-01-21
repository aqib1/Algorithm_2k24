package org.algorithms.io.revision;

import org.algorithms.io.binarytree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPostOrder {
    private int[] postorder;
    private Map<Integer, Integer> inorderWithIndex;
    private int postorderIndex;
    // Time complexity O(n) and Space complexity O(n)
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorderWithIndex = new HashMap<>();
        this.postorder = postorder;
        this.postorderIndex = postorder.length - 1;
        int index = 0;
        for(int i: inorder) inorderWithIndex.put(i, index++);
        return helper(0, postorder.length - 1);
    }

    private TreeNode helper(int left, int right) {
        if(left > right)
            return null;
        var root = new TreeNode(postorder[postorderIndex--]);
        int rootIndex = this.inorderWithIndex.get(root.val);
        root.right = helper(rootIndex + 1, right);
        root.left = helper(left, rootIndex - 1);
        return root;
    }
}
