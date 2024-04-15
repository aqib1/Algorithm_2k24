package org.algorithms.io.amazon2k25.binaryTree;

import org.algorithms.io.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderWithoutRecursion {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(levelOrder(root));
    }

    // Time complexity O(n) and space O(n)
    public static List<List<Integer>> levelOrder(TreeNode root) {
       if(root == null)
           return new ArrayList<>();

        List<List<Integer>> response = new ArrayList<>();
        int level = -1;
        Queue<TreeNode> fifo = new LinkedList<>();
        fifo.add(root);

        while(!fifo.isEmpty()) {
            level++;
            int size = fifo.size();
            response.add(new ArrayList<>());
            while (size > 0) {
                var current = fifo.poll();
                response.get(level).add(current.val);

                if(current.left != null) {
                    fifo.add(current.left);
                }

                if(current.right != null) {
                    fifo.add(current.right);
                }
                size--;
            }
        }

        return response;
    }
}
