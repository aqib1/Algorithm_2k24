package org.algorithms.io.leetcode2k26;

import java.util.Arrays;
import java.util.Stack;

public class Leetcode150_1 {
    interface Node {
        int evalute();

        static Node fromString(String str) {
            return switch(str) {
              case "/" -> new DivNode();
              case "*" -> new MulNode();
              case "-" -> new SubNode();
              case "+" -> new AddNode();
              default -> new NumericNode(str);
            };
        }
    }

    static abstract class OperatorNode implements Node {
        private Node left;
        private Node right;

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    static class NumericNode implements Node {
        private final String number;
        public NumericNode(String number) {
            this.number = number;
        }

        @Override
        public int evalute() {
            return Integer.parseInt(number);
        }
    }

    static class DivNode extends OperatorNode {

        @Override
        public int evalute() {
            return getLeft().evalute() / getRight().evalute();
        }
    }

    static class MulNode extends OperatorNode {

        @Override
        public int evalute() {
            return getLeft().evalute() * getRight().evalute();
        }
    }

    static class AddNode extends OperatorNode {

        @Override
        public int evalute() {
            return getLeft().evalute() + getRight().evalute();
        }
    }

    static class SubNode extends OperatorNode {

        @Override
        public int evalute() {
            return getLeft().evalute() - getRight().evalute();
        }
    }

    public static void main(String[] args) {
        var le = new Leetcode150_1();
        System.out.println(le.evalRPN(
                new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"}
        ));
    }

    // Time complexity O(N), Space Complexity O(N)
    public int evalRPN(String[] tokens) {
        var stack = new Stack<Node>();

        Arrays.stream(tokens).forEach(it -> {
            var node = Node.fromString(it);
            if(node instanceof OperatorNode operatorNode) {
                operatorNode.setRight(stack.pop());
                operatorNode.setLeft(stack.pop());
                stack.push(operatorNode);
            } else {
                stack.push(node);
            }
        });
        return stack.pop().evalute();
    }
}
