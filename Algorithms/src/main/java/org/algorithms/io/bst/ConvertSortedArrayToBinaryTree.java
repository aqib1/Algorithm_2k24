package org.algorithms.io.bst;

import org.algorithms.io.binarytree.TreeNode;

public class ConvertSortedArrayToBinaryTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0)
            return null;
        return toBST(nums, 0, nums.length - 1);
    }

    // Time complexity O(N)
    // Space complexity OLog(N)
    private TreeNode toBST(int[] nums, int low, int high) {
        if(low > high)
            return null;
        int mid = low + (high - low) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = toBST(nums, low, mid - 1);
        root.right = toBST(nums, mid + 1, high);

        return root;
    }
}
