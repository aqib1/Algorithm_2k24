package org.algorithms.io.revision;

import java.util.Stack;

public class BasicCalculator {
    interface Node {
        int evalute();

        static Node fromString(String str) {
            return switch (str) {
                case "*" -> new MulNode();
                case "/" -> new DivNode();
                case "+" -> new AddNode();
                case "-" -> new SubNode();
                default -> new NumericNode(str);
            };
        }
    }

    static abstract class OperatorNode implements Node {
        private Node left;
        private Node right;

        public void setRight(Node right) {
            this.right = right;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public Node getLeft() {
            return left;
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
        var cal = new BasicCalculator();
        System.out.println(cal.calculate("(1+(4+5+2)-3)+(6+8)"));
    }

    // Time complexity O(n)
    // Space O(n)
    public int calculate(String s) {
        s = s.trim();
        s = s.replaceAll("\\s", "");
        // Time complexity O(n)
        // Space O(n)
        var postfix = infixToPostfix(s);
        return expressionTree(postfix).evalute();
    }

    public Node expressionTree(String postfix) {
        var stack = new Stack<Node>();
        var digit = "";
        for (char ch : postfix.toCharArray()) {
            if (isDigit(ch)) {
                digit = digit.concat(String.valueOf(ch));
            } else if (ch == ';') {
                stack.push(Node.fromString(digit));
                digit = "";
            } else {
                var node = Node.fromString(String.valueOf(ch));
                if (node instanceof OperatorNode operator) {
                    operator.setRight(stack.pop());
                    operator.setLeft(stack.pop());
                    stack.push(operator);
                    digit = "";
                }
            }
        }
        return stack.pop();
    }

    public String infixToPostfix(String infix) {
        var postfix = new StringBuilder();
        var operatorStack = new Stack<Character>();
        var digit = "";
        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);
            if (isDigit(ch)) {
                digit = digit.concat(String.valueOf(ch));
            } else {
                if (!digit.isBlank())
                    postfix.append(digit).append(";");
                digit = "";

                if (ch == '-' && (i == 0 || (!isDigit(infix.charAt(i - 1)) && infix.charAt(i - 1) != ')') || infix.charAt(i - 1) == '(')) {
                    postfix.append("0").append(";");
                }

                while (!operatorStack.isEmpty() &&
                        precedence(ch) != -1 &&
                        precedence(operatorStack.peek()) >= precedence(ch)) {
                    postfix.append(operatorStack.pop());
                }

                if (ch == ')') {
                    char opTop;
                    while (!operatorStack.isEmpty() && (opTop = operatorStack.pop()) != '(') {
                        postfix.append(opTop);
                    }
                } else {
                    operatorStack.push(ch);
                }
            }
        }


        if (!digit.isBlank())
            postfix.append(digit).append(";");

        while (!operatorStack.isEmpty()) postfix.append(operatorStack.pop());

        return postfix.toString();
    }

    public int precedence(char ch) {
        return switch (ch) {
            case '^' -> 4;
            case '/', '*' -> 2;
            case '+', '-' -> 1;
            default -> -1;
        };
    }

    public boolean isDigit(char ch) {
        return ch != '^' && ch != '/' && ch != '+'
                && ch != '-' && ch != '*' && ch != '(' && ch != ')' && ch != ';';
    }
}
