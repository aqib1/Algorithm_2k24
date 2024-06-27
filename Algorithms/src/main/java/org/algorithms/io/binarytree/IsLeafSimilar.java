package org.algorithms.io.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class IsLeafSimilar {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Queue<Integer> leaf1 = new LinkedList<>();
        Queue<Integer> leaf2 = new LinkedList<>();

        fillUpLeafs(root1, leaf1);
        fillUpLeafs(root2, leaf2);

        return leaf1.equals(leaf2);
    }



    private void fillUpLeafs(TreeNode root1, Queue<Integer> leaf) {
        if (root1 == null)
            return;
        if (root1.left == null && root1.right == null)
            leaf.add(root1.val);

        fillUpLeafs(root1.left, leaf);
        fillUpLeafs(root1.right, leaf);
    }
}
