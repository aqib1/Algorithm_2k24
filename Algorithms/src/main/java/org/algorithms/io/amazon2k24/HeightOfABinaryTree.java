package org.algorithms.io.amazon2k24;

class Node {
    int data;
    Node left;
    Node right;
}

// Height = Depth - 1
// Time complexity is O(N) where space is O(N)
public class HeightOfABinaryTree {
    public static int height(Node root) {
        return height(root, 0) - 1;
    }

    public static int height(Node root, int depth) {
        if (root == null)
            return depth;

        return Math.max(
                height(root.left, depth + 1),
                height(root.right, depth + 1)
        );
    }
}
