package org.algorithms.io.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MinValue {

    // BT is a BST
    public int minValue(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            if(current != null && current.left == null)
                return current.data;
            if(current != null)
                queue.add(current.left);
        }

        return -1;
    }

    public int depthFirst(Node root) {
        if(root == null)
            return -1;
        if(root.left == null)
            return root.data;

        return depthFirst(root.left);
    }
}
