package org.algorithms.io.revision;


import java.util.Objects;
import java.util.Stack;

public class ExpressionTree {
    public abstract static class Node {
        public abstract double evaluate();
        public static Node getNode(String value) {
            return switch(value) {
                 case "*" -> new MulNode();
                 case "/" -> new DivNode();
                 case "-" -> new SubNode();
                 case "+" -> new AdditionNode();
                default -> new NumericNode(value);
            };
        }
    }

    public abstract static class OperatorNode extends Node {
        private Node left;
        private Node right;

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }
    }

    public static class AdditionNode extends OperatorNode {

        @Override
        public double evaluate() {
            return getLeft().evaluate() + getRight().evaluate();
        }
    }

    public static class SubNode extends OperatorNode {

        @Override
        public double evaluate() {
            return getLeft().evaluate() - getRight().evaluate();
        }
    }

    public static class MulNode extends OperatorNode {

        @Override
        public double evaluate() {
            return getLeft().evaluate() * getRight().evaluate();
        }
    }

    public static class DivNode extends OperatorNode {

        @Override
        public double evaluate() {
            return getLeft().evaluate() / getRight().evaluate();
        }
    }

    public static class NumericNode extends Node {
        public final String node;
        public NumericNode(String node) {
            this.node = node;
        }

        @Override
        public double evaluate() {
            return Double.parseDouble(node);
        }
    }

    // Construction Time O(n).
    // Going through all vertexes of tree is O(V + E).
    // Space complexity O(n).
    public Node buildTree(String[] postfix) {
        if(Objects.isNull(postfix) || postfix.length < 3)
            return null;

        var stack = new Stack<Node>();

        for(var value: postfix) {
            var currentNode = Node.getNode(value);
            if(currentNode instanceof NumericNode numeric) {
                stack.push(numeric);
            } else {
                var operatorNode = (OperatorNode)currentNode;
                operatorNode.setLeft(stack.pop());
                operatorNode.setRight(stack.pop());
                stack.push(operatorNode);
            }
        }
        return stack.pop();
    }

}
