package org.algorithms.io.binarytree;

import java.util.Map;

public class ConstructBinaryTreeFromPreOrder {
    private int[] preorder;
    private int preorderIndex;
    private Map<Integer, Integer> inorderMap;
    // Pre Order = NLR (construct left first)
    // Space complexity O(n)
    // Time complexity O(n)
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        int inorderIndex = 0;
        for(int in : inorder) inorderMap.put(in, inorderIndex++);

        return helper(0, preorder.length - 1);
    }

    private TreeNode helper(int left, int right) {
        if(left > right)
            return null;
        TreeNode root = new TreeNode(this.preorder[preorderIndex++]);
        int rootIndex = inorderMap.get(root.val);
        root.left = helper(left, rootIndex - 1);
        root.right = helper(rootIndex + 1, right);
        return root;
    }
}
