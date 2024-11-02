package org.algorithms.io.amazon2k24;

import org.algorithms.io.tree.TreeNode;

import java.util.HashMap;

public class MaxLevelSum {
  // Time complexity O(N)
  // Space complexity O(N)
    public int solve(TreeNode A) {
        var levelSumMap = new HashMap<Integer, Integer>();
        prepareSumByLevel(A, 1, levelSumMap);
        int maxSum = Integer.MIN_VALUE;
        int result = 0;
        for(int key: levelSumMap.keySet()) {
            if(maxSum < levelSumMap.get(key)) {
                maxSum = levelSumMap.get(key);
                result = key;
            }
        }

        return result;
    }

    private void prepareSumByLevel(TreeNode node, int level, HashMap<Integer, Integer> levelSumMap) {
        if(node == null) return;
        levelSumMap.put(level, levelSumMap.getOrDefault(level, 0) + node.val);
        prepareSumByLevel(node.left, level + 1, levelSumMap);
        prepareSumByLevel(node.right, level + 1, levelSumMap);
    }
}
