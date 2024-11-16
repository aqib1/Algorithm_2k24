package org.algorithms.io.amazon2k24;

import org.algorithms.io.tree.TreeNode;

import java.util.HashSet;

public class TwoSumBSTUsingHashSet {
    private boolean found = false;
    // Time complexity 2*O(V + E)  = O(V + E)
    // Space O(V + E)
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        var set = new HashSet<Integer>();
        // O(V + E)
        fillDifference(root1, target, set);
        // O(V + E)
        findPair(root2, set);

        return found;
    }

    private void findPair(TreeNode root2, HashSet<Integer> set) {
        if(root2 == null) return;

        findPair(root2.left, set);
        if(set.contains(root2.val))
            found = true;
        findPair(root2.right, set);
    }

    private void fillDifference(TreeNode root1, int target, HashSet<Integer> set) {
        if(root1 == null) return;
        fillDifference(root1.left, target, set);
        set.add(target - root1.val);
        fillDifference(root1.right, target, set);
    }
}
