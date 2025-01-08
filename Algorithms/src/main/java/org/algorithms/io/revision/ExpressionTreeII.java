package org.algorithms.io.revision;

import java.util.Stack;

class Node {
    char val;
    Node left;
    Node right;

    Node() {
        this.val = ' ';
    }

    Node(char val) {
        this.val = val;
    }

    Node(char val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class ExpressionTreeII {
    // [2, 3, 5, 2, *, /, -, 1, +]
    public static void main(String[] args) {
        var expression = new ExpressionTreeII();
        System.out.println(expression.infixToPostfix("a+b*(c^d-e)^(f+g*h)-i"));
    }

    public Node expTree(String s) {
        var postfix = infixToPostfix(s);
        var stack = new Stack<Node>();

        for (char ch : postfix.toCharArray()) {
            if (isDigit(ch)) {
                stack.push(new Node(ch));
            } else {
                var right = stack.pop();
                var left = stack.pop();
                var operator = new Node(ch, left, right);
                stack.push(operator);
            }
        }
        return stack.pop();
    }

    public String infixToPostfix(String exp) {
        var postfix = new StringBuilder();
        var operatorsStack = new Stack<Character>();
        for (char ch : exp.toCharArray()) {
            if (isDigit(ch)) {
                postfix.append(ch);
            } else {
                // keep appending operator until have high precedence then current char
                while (!operatorsStack.isEmpty()
                        && precedence(ch) != -1
                        && precedence(operatorsStack.peek()) >= precedence(ch)) {
                    postfix.append(operatorsStack.pop());
                }

                // in case of brackets keep tracking backwards until found start of bracket
                if (ch == ')') {
                    char opChar;
                    while (!operatorsStack.isEmpty() && (opChar = operatorsStack.pop()) != '(') {
                        // append to result
                        postfix.append(opChar);
                    }
                } else {
                    operatorsStack.push(ch); // adding current operator to stack
                }
            }
        }

        while (!operatorsStack.isEmpty()) {
            postfix.append(operatorsStack.pop());
        }

        return postfix.toString();
    }

    public boolean isDigit(char ch) {
        return ch != '^' &&
                ch != '*' && ch != '/'
                && ch != '-' && ch != '+'
                && ch != '(' && ch != ')';
    }

    public int precedence(char ch) {
        return switch (ch) {
            case '^' -> 3;
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            default -> -1;
        };
    }
}
