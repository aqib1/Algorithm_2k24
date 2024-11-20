package org.algorithms.io.stacks;


import java.util.LinkedList;
import java.util.Queue;
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

public class InfixToPostfix {
    public static void main(String[] args) {
        String infix = "2-3/(5*2)+1";
        System.out.println(
                infixToPostfix(infix)
        );
    }

    // Time complexity O(n) where n is the number of character
    // Space complexity O(n)
    public static String infixToPostfix(String exp) {
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

    public static boolean isDigit(char ch) {
        return ch != '^' &&
                ch != '*' && ch != '/'
                && ch != '-' && ch != '+'
                && ch != '(' && ch != ')';
    }

    public static int precedence(char ch) {
        return switch (ch) {
            case '^' -> 3;
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            default -> -1;
        };
    }
}

