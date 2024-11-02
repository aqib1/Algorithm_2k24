package org.algorithms.io.amazon2k24;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
    class Node {
        int data;
        Node left;
        Node right;
    }

    public static void levelOrder(LevelOrder.Node root) {
        Queue<LevelOrder.Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            LevelOrder.Node current = queue.poll();
            System.out.print(current.data + " ");
            if(current.left != null) queue.add(current.left);
            if(current.right != null) queue.add(current.right);
        }
    }
}
