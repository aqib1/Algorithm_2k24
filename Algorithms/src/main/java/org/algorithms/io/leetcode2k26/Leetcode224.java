package org.algorithms.io.leetcode2k26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.Stack;

public class Leetcode224 {
    interface Node {
        int evaluate();
        static Node fromString(String node) {
            return switch(node) {
              case "+" -> new AddNode();
              case "-" -> new SubNode();
              case "*" -> new MulNode();
              case "/" -> new DivNode();
              default -> new NumericNode(node);
            };
        }
    }

    static abstract class OperatorNode implements Node {
        private Node first;
        private Node second;

        public void setFirst(Node first) {
            this.first = first;
        }

        public void setSecond(Node second) {
            this.second = second;
        }

        public Node getFirst() {
            return first;
        }

        public Node getSecond() {
            return second;
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


    private boolean isDigit(char ch) {
        return !OP_CHAR.contains(ch);
    }

    public int precedence(char ch) {
        return switch(ch) {
            case '^' -> 4;
            case '/', '*' -> 2;
            case '+', '-' -> 1;
            default -> -1;
        };
    }

    public String[] infixToPostfix(String infix) {
        var postFix = new ArrayList<String>();
        var operatorStack = new Stack<Character>();
        var digit = "";
        for(int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);
            if(isDigit(ch)) {
                digit = digit.concat(String.valueOf(ch));
            } else {
                if (!digit.isBlank()) {
                    postFix.add(digit);
                }
                digit = "";
                if(ch == '-' && (i == 0 || (!isDigit(infix.charAt(i - 1)) && infix.charAt(i - 1) != ')') || infix.charAt(i - 1) == '(')) {
                    postFix.add("0");
                }

                while(!operatorStack.isEmpty() && precedence(ch) != -1
                        && precedence(operatorStack.peek()) >= precedence(ch)) {
                    postFix.add(String.valueOf(operatorStack.pop()));
                }

                if(ch == ')') {
                    char opTop;
                    while(!operatorStack.isEmpty() && (opTop = operatorStack.pop()) != '(') {
                        postFix.add(String.valueOf(opTop));
                    }
                } else {
                    operatorStack.push(ch);
                }
            }
        }

        if(!digit.isBlank())
            postFix.add(digit);

        while(!operatorStack.isEmpty()) {
            postFix.add(String.valueOf(operatorStack.pop()));
        }

        return postFix.toArray(new String[0]);
    }

    public int calculate(String eq) {
        eq = eq.trim();
        eq = eq.replaceAll("\\s", "");

        try {
            return Integer.parseInt(eq);
        } catch (NumberFormatException ex) {
            // ignore
        }

        var op = infixToPostfix(eq);
        System.out.println(Arrays.toString(op));
        var stack = new Stack<Node>();
        Arrays.stream(op).forEach(it -> {
            var node = Node.fromString(it);
            if(node instanceof OperatorNode operatorNode) {
                operatorNode.setFirst(stack.pop());
                operatorNode.setSecond(stack.pop());
                stack.push(operatorNode);
            } else {
                stack.push(node);
            }
        });
        return stack.pop().evaluate();
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

    private static final Set<Character> OP_CHAR = Set.of(
            '^', '+', '-', '/', '*', '(', ')'
    );

    public static void main(String[] args) {
        var leet = new Leetcode224();
        System.out.println(leet.calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
