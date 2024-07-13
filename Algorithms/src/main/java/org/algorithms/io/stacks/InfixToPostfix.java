package org.algorithms.io.stacks;

import java.util.Stack;

public class InfixToPostfix {
    public static void main(String[] args) {
        String infix = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(
                calculatePostfix(
                        infixToPostfix(infix)
                )
        );
    }

    private static int calculatePostfix(String postfix) {
        var operandStack = new Stack<Integer>();
        for (char ch : postfix.toCharArray()) {
            if (Character.isDigit(ch)) {
                operandStack.push(Integer.parseInt("" + ch));
            } else {
                int second = operandStack.pop();
                int first = operandStack.pop();
                int result = operation(first, second, ch);
                operandStack.push(result);
            }
        }

        return operandStack.pop();
    }

    private static int operation(int first, int second, char ch) {
        return switch (ch) {
            case '+' -> first + second;
            case '-' -> first - second;
            case '*' -> first * second;
            case '/' -> first / second;
            default -> 0;
        };
    }

    private static String infixToPostfix(String infix) {
        var postfix = new StringBuilder();
        var operatorStack = new Stack<Character>();

        for (char ch : infix.toCharArray()) {
            if (Character.isDigit(ch)) {
                postfix.append(ch);
            } else {
                if (!operatorStack.isEmpty()) {
                    var opTop = operatorStack.pop();
                    if (opTop == '(') {
                        operatorStack.push(opTop);
                    } else if (precedence(opTop) > precedence(ch) && precedence(ch) != -1) {
                        postfix.append(opTop);
                    } else {
                        operatorStack.push(opTop);
                    }
                }
                if (ch == ')') {
                    char pop;
                    while ((pop = operatorStack.pop()) != '(') {
                        postfix.append(pop);
                    }
                } else {
                    operatorStack.add(ch);
                }
            }
        }

        while (!operatorStack.isEmpty()) {
            postfix.append(operatorStack.pop());
        }

        return postfix.toString();
    }

    private static int precedence(char operator) {
        return switch (operator) {
            case '/' -> 3;
            case '*' -> 2;
            case '+' -> 1;
            case '-' -> 0;
            default -> -1;
        };
    }
}

