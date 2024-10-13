package org.algorithms.io.tree;

import java.util.ArrayList;

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
    // N, L, R
    public void preorder(Node root) {
        if(root == null) return;
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    // L, N, R
    public void inorder(Node root) {
        if(root == null) return;
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    // L, R, N
    public void postorder(Node root) {
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data);
    }
}
