package org.algorithms.io.binarytree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LowestCommonAncestor {

    // Time complexity O(n) and Space complexity O(n)
    public TreeNode lowestCommonAncestor(
            TreeNode root,
            TreeNode p,
            TreeNode q
    ) {
        var parentByChild = new HashMap<Integer, TreeNode>();
        var ancestors = new HashSet<Integer>();
        Queue<TreeNode> bfs = new LinkedList<>();
        parentByChild.put(root.val, null); // root does not have any parent
        bfs.add(root);

        while(!bfs.isEmpty()) {
            var current = bfs.poll();

            if(current.left != null) {
                bfs.add(current.left);
                parentByChild.put(current.left.val, current);
            }

            if(current.right != null) {
                bfs.add(current.right);
                parentByChild.put(current.right.val, current);
            }
        }

        // fill-up all p ancestors
        while(p != null && q != null && p.val == q.val) {
            ancestors.add(p.val);
            p = parentByChild.get(p.val);
        }

        // check when q ancestor match with p
        while(q != null && !ancestors.contains(q.val)) {
            q = parentByChild.get(q.val);
        }

        return q;
    }
}
