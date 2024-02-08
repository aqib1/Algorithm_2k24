package org.algorithms.io.bst;

public class ConstructBst {
    static class Node {
        int val;
        Node left;
        Node right;
        Node(int val) {
            this.val = val;
        }
    }

    private Node root;

    // Time complexity OLog(n) where n is number of nodes
    // Space complexity OLog(n)
    public Node constructBst(int val) {
        if(this.root == null) {
            this.root = new Node(val);
        } else {
            addChild(root, val);
        }

        return root;
    }

    private void addChild(Node root, int val) {
        if(val > root.val) {
            if(root.right == null) {
                root.right = new Node(val);
            } else {
                addChild(root.right, val);
            }
        } else {
            if(root.left == null) {
                root.left = new Node(val);
            } else {
                addChild(root.left, val);
            }
        }
    }
}
