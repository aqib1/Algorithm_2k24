package org.algorithms.io.binarytree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class IsLeafSimilar {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Queue<Integer> leaf1 = new LinkedList<>();
        fillUpLeafs(root1, leaf1);

        Queue<Integer> leaf2 = new LinkedList<>();
        fillUpLeafs(root2, leaf2);

        if(leaf1.size() != leaf2.size())
            return false;

       while(!leaf1.isEmpty()) {
           if(!Objects.equals(leaf1.poll(), leaf2.poll()))
               return false;
       }

        return true;
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
