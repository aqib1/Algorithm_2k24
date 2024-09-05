package org.algorithms.io.amazon2k24;

import java.util.Stack;

public class BasicCalculatorII {
    // Inheritance
    interface Node {
        int evaluate();

        static Node fromString(String node) {
            return switch (node) {
                case "+" -> new AddNode();
                case "-" -> new SubNode();
                case "*" -> new MulNode();
                case "/" -> new DivNode();
                default -> new NumericNode(node);
            };
        }
    }

    abstract static class OperatorNode implements Node {
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

    static class AddNode extends OperatorNode {

        @Override
        public int evaluate() {
            return getLeft().evaluate() + getRight().evaluate();
        }
    }

    static class SubNode extends OperatorNode {

        @Override
        public int evaluate() {
            return getLeft().evaluate() - getRight().evaluate();
        }
    }

    static class MulNode extends OperatorNode {

        @Override
        public int evaluate() {
            return getLeft().evaluate() * getRight().evaluate();
        }
    }

    static class DivNode extends OperatorNode {

        @Override
        public int evaluate() {
            return getLeft().evaluate() / getRight().evaluate();
        }
    }

    static class NumericNode implements Node {
        private final String value;

        public NumericNode(String value) {
            this.value = value;
        }

        @Override
        public int evaluate() {
            return Integer.parseInt(value);
        }
    }

    // Time complexity is O(V + E)
    // Space complexity O(N) where N is number of characters of s
    public static void main(String[] args) {
        var cal = new BasicCalculatorII();
        System.out.println(cal.calculate("1-1-1"));
    }

    public int calculate(String s) {
        s = s.trim();
        s = s.replaceAll("\\s", "");
        var postfix = infixToPostfix(s);
        var expressionTree = expressionTree(postfix);
        return expressionTree.evaluate();
    }

    private Node expressionTree(String postfix) {
        var stack = new Stack<Node>();
        var digit = "";
        for (char ch : postfix.toCharArray()) {
            var chStr = String.valueOf(ch);
            if (!isOperator(chStr)) {
                if (chStr.equals(";")) {
                    stack.push(Node.fromString(digit));
                    digit = "";
                } else {
                    digit = digit.concat(chStr);
                }
            } else {
                var right = stack.pop();
                var left = stack.pop();

                OperatorNode operator = (OperatorNode) Node.fromString(chStr);
                operator.setLeft(left);
                operator.setRight(right);
                stack.push(operator);
            }
        }
        return stack.pop();
    }

    private String infixToPostfix(String s) {
        var postfix = new StringBuilder();
        var operatorStack = new Stack<String>();
        String digit = "";
        for (char ch : s.toCharArray()) {
            var chStr = String.valueOf(ch);
            if (isOperator(chStr)) {
                digit = digit.concat(";");
                postfix.append(digit);
                digit = "";

                while (!operatorStack.isEmpty() &&
                        precedence(chStr) != -1 &&
                        precedence(operatorStack.peek()) >= precedence(chStr)) {
                    postfix.append(operatorStack.pop());
                }

                operatorStack.push(chStr);
            } else {
                digit = digit.concat(String.valueOf(ch));
            }
        }

        if (!digit.isEmpty()) postfix.append(digit.concat(";"));

        while (!operatorStack.isEmpty()) postfix.append(operatorStack.pop());

        return postfix.toString();
    }

    public boolean isOperator(String op) {
        return op.equals("+") || op.equals("-") || op.equals("/") || op.equals("*");
    }

    public int precedence(String op) {
        return switch (op) {
            case "/", "*" -> 2;
            case "+", "-" -> 1;
            default -> -1;
        };
    }
}
