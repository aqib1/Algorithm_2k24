package org.algorithms.io.binarytree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class BinaryTreeSerializer {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(serialize(root));
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        return serialize(root, "");
    }

    // Time complexity O(n) and space complexity O(n)
    public static String serialize(TreeNode root, String res) {
        if(root == null) {
            res += "null,";
        } else {
            res += root.val + ",";
            res = serialize(root.left, res);
            res = serialize(root.right, res);

        }
        return res;
    }

    public static TreeNode deserialize(String data) {
        if(data.isBlank()) {
            return null;
        }

        var split = data.split(",");
        Queue<String> fifo = new LinkedList<>(Arrays.asList(split));
        return deserialize(fifo);
    }

    public static TreeNode deserialize(Queue<String> data) {
        if(data.peek().equals("null")) {
            data.poll();
            return null;
        }

        var root = new TreeNode(Integer.parseInt(Objects.requireNonNull(data.poll())));
        root.left = deserialize(data);
        root.right = deserialize(data);

        return root;
    }
}
