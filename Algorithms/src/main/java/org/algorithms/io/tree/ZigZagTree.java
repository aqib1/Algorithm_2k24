package org.algorithms.io.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class ZigZagTree {
    public static void main(String[] args) {
        var zigzag = new ZigZagTree();
        Node node = new Node(1);
        node.left = new Node(3);
        node.right = new Node(2);
        node.left.left = new Node(4);
        node.left.right = new Node(5);

        System.out.println(zigzag.zigZagTraversal(node));
    }
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    public List<Integer> zigZagTraversal(Node root) {
        ArrayList<Integer> response = new ArrayList<>();
        Stack<Node> leftToRight = new Stack<>();
        Stack<Node> rightToLeft = new Stack<>();
        rightToLeft.push(root);

        while(!leftToRight.isEmpty() || !rightToLeft.isEmpty()) {
            if(!rightToLeft.isEmpty()) {
                Node node = rightToLeft.pop();
                if(!Objects.isNull(node)) {
                    response.add(node.data);
                    leftToRight.push(node.left);
                    leftToRight.push(node.right);
                }
            } else {
                while(!leftToRight.isEmpty()) {
                    Node node = leftToRight.pop();
                    if(!Objects.isNull(node)) {
                        response.add(node.data);
                        rightToLeft.push(node.right);
                        rightToLeft.push(node.left);
                    }
                }
            }
        }
        return response;
    }
}
