package org.algorithms.io.binarytree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPostOrder {
    private int[] postorder;
    private int postorderIndex;
    private Map<Integer, Integer> inorderIndex;

    // Time complexity O(n)
    // Space complexity O(n)
    // Post Order = LRN (Construct right firstleetco
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorderIndex = new HashMap<>();
        this.postorder = postorder;
        postorderIndex = postorder.length - 1;
        int index = 0;
        for(int in : inorder) inorderIndex.put(in, index++);

        return helper(0, inorder.length - 1);
    }

    private TreeNode helper(int left, int right) {
        if(left > right)
            return null;

        TreeNode rootNode = new TreeNode(postorder[postorderIndex]);
        int rootIndex = inorderIndex.get(rootNode.val);
        postorderIndex--;
        rootNode.right = helper(rootIndex + 1, right);
        rootNode.left = helper(left, rootIndex - 1);
        return rootNode;
    }
}
