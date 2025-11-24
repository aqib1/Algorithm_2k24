package org.algorithms.io.leetcode2k26;

import java.util.Arrays;
import java.util.Stack;

public class Leetcode150_11 {
    interface Node {
        int evaluate();
        static Node fromString(String value) {
            return switch(value) {
                case "/" -> new DivNode();
                case "*" -> new MulNode();
                case "+" -> new AddNode();
                case "-" -> new SubNode();
                default -> new NumericNode(value);
            };
        }
    }

    abstract static class OperatorNode implements Node {
        private Node first;
        private Node second;

        public Node getFirst() {
            return first;
        }

        public void setFirst(Node first) {
            this.first = first;
        }

        public Node getSecond() {
            return second;
        }

        public void setSecond(Node second) {
            this.second = second;
        }
    }

    static class NumericNode implements Node {
        private final String number;
        public NumericNode(String number) {
            this.number = number;
        }

        @Override
        public int evaluate() {
            return Integer.parseInt(number);
        }
    }

    static class DivNode extends OperatorNode {
        @Override
        public int evaluate() {
            return getSecond().evaluate() / getFirst().evaluate();
        }
    }

    static class MulNode extends OperatorNode {
        @Override
        public int evaluate() {
            return getSecond().evaluate() * getFirst().evaluate();
        }
    }

    static class AddNode extends OperatorNode {
        @Override
        public int evaluate() {
            return getSecond().evaluate() + getFirst().evaluate();
        }
    }

    static class SubNode extends OperatorNode {
        @Override
        public int evaluate() {
            return getSecond().evaluate() - getFirst().evaluate();
        }
    }

    // O(N) and O(N)
    public int evalRPN(String[] tokens) {
        var stack = new Stack<Node>();
        Arrays.stream(tokens).forEach(it -> {
            var operator = Node.fromString(it);
            if(operator instanceof OperatorNode operatorNode) {
                operatorNode.setFirst(stack.pop());
                operatorNode.setSecond(stack.pop());
                stack.push(operatorNode);
            } else {
                stack.push(operator);
            }
        });
        return stack.pop().evaluate();
    }


    public static void main(String[] args) {
        var leetcode = new Leetcode150_11();
        System.out.println(
                leetcode.evalRPN(
                        new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"}
                )
        );
    }
}
