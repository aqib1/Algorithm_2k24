package org.algorithms.io.binarytree;

import java.util.*;

public class LevelOrder {

    // Time complexity O(n)
    // Space complexity O(n)
    public List<List<Integer>> levelOrderRecur(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        postOrder(root, result, 0);
        return result;
    }

    private void postOrder(TreeNode root, List<List<Integer>> result, int height) {
        if(root == null)
            return;
        if(result.size() == height)
            result.add(new ArrayList<>());

        result.get(height).add(root.val);

        postOrder(root.left, result, height + 1);
        postOrder(root.right, result, height + 1);
    }


    // Time complexity O(n)
    // Space complexity O(2n)
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();

        Map<Integer , List<Integer>> prepare = new HashMap<>();
        Queue<Map.Entry<TreeNode, Integer>> nodeByIndex = new LinkedList<>();
        nodeByIndex.add(new AbstractMap.SimpleEntry<>(root, 0));

        while(!nodeByIndex.isEmpty()) {
            var current = nodeByIndex.poll();
            var list = prepare.getOrDefault(current.getValue(), new ArrayList<>());
            list.add(current.getKey().val);
            prepare.put(current.getValue(), list);

            if(current.getKey().left != null) {
                nodeByIndex.add(new AbstractMap.SimpleEntry<>(current.getKey().left, current.getValue() + 1));
            }

            if(current.getKey().right != null) {
                nodeByIndex.add(new AbstractMap.SimpleEntry<>(current.getKey().right, current.getValue() + 1));
            }
        }

        return new ArrayList<>(prepare.values());
    }
}
