package org.algorithms.io.interviewPrep2k25.tree;


public class InOrderSuccessorAndPredecessor {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // Time complexity O(n) and space O(n)
    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        while(root != null) {
            if(key < root.data) {
                suc[0] = root;
                root = root.left;
            } else if(key > root.data) {
                pre[0] = root;
                root = root.right;
            } else {
                if(root.left != null)
                    pre[0] = rightMost(root.left);
                if(root.right != null)
                    suc[0] = leftMost(root.right);
                break;
            }
        }
    }

    public static Node rightMost(Node node) {
        while(node.right != null) node = node.right;
        return node;
    }

    public static Node leftMost(Node node) {
        while(node.left != null) node = node.left;
        return node;
    }
}
