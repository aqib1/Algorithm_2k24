package org.algorithms.io.tree;

public class ConstructBstFromPostorder {
    public static Node constructTree(int[] post, int n) {
        if(post.length == 0)
            return null;
        Node root = new Node(post[0]);
        for(int i = 1; i < n; i++) {
            construct(root, post[i]);
        }
        return root;
    }

    public static Node construct(Node root, int data) {
        if(root == null)
            return new Node(data);
        if(root.data > data) {
            root.left = construct(root.left, data);
        } else if(root.data < data) {
            root.right = construct(root.right, data);
        }
        return root;
    }
}
