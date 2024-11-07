package org.algorithms.io.tree;

import java.util.*;

public class VerticalOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        var verticalOrder = new VerticalOrder();

        System.out.println(verticalOrder.verticalTraversal(root));

    }

    // Time O(n) where n is number of nodes.
    // Space O(n)
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        var constructVertical = new TreeMap<Integer, TreeMap<Integer, List<Integer>>>();
        List<List<Integer>> res = new ArrayList<>();
        verticalTraversal(root, constructVertical, 0, 0);
        for(var entry: constructVertical.entrySet()) {
            for(var innerEntry : entry.getValue().entrySet()) {
                 Collections.sort(innerEntry.getValue());
            }
        }

        for(var entry: constructVertical.entrySet()) {
            var data = new ArrayList<Integer>();
            for(var innerEntry : entry.getValue().entrySet()) {
                data.addAll(innerEntry.getValue());
            }

            res.add(data);
        }

        return res;
    }

    public void verticalTraversal(
            TreeNode root,
            TreeMap<Integer, TreeMap<Integer, List<Integer>>> constructVertical,
            int row,
            int col
    ) {
        if(root == null) return;
        verticalTraversal(root.left, constructVertical, row + 1, col - 1);

        var colMap = constructVertical.getOrDefault(col, new TreeMap<>());
        var data = colMap.getOrDefault(row, new ArrayList<>());
        data.add(root.val);
        colMap.put(row, data);
        constructVertical.put(col, colMap);

        verticalTraversal(root.right, constructVertical, row + 1, col + 1);
    }

}
