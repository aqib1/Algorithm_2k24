package org.algorithms.io.tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
public class BinaryTree {

    // DFS - Depth first search

    // N, L, R
    public void preorder(Node root) {
        if(root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // L, N, R
    public void inorder(Node root) {
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // L, R, N
    public void postorder(Node root) {
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    // bfs - Breadth first search / Level order search
    public void bfs(Node root) {
        if(root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            var current = queue.poll();
            System.out.print(current.data + " ");

            if(current.left != null) queue.add(current.left);
            if(current.right != null) queue.add(current.right);
        }
    }

    public int maxDepthRecursive(Node root) {
        return maxDepth(root, 0);
    }

    public int maxDepth(Node root, int depth) {
        if(root == null) return depth;

        return Math.max(
                maxDepth(root.left, depth + 1),
                maxDepth(root.right, depth + 1)
        );
    }

    public int maxDepth(Node root) {
        if(root == null) return 0;
        int depth = 1;
        int maxDepth = Integer.MIN_VALUE;
        Queue<Map.Entry<Node, Integer>> queue = new LinkedList<>();
        queue.add(Map.entry(root, depth));
        while(!queue.isEmpty()) {
            var current = queue.poll();
            maxDepth = Math.max(maxDepth, current.getValue());

            if(current.getKey().left != null) queue.add(
                    Map.entry(current.getKey().left, current.getValue() + 1)
            );
            if(current.getKey().right != null) queue.add(
                    Map.entry(current.getKey().right, current.getValue() + 1)
            );
        }

        return maxDepth;
    }
}
