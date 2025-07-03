package org.algorithms.io.stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
 * <p>
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "1 + 1"
 * Output: 2
 * Example 2:
 * <p>
 * Input: s = " 2-1 + 2 "
 * Output: 3
 * Example 3:
 * <p>
 * Input: s = "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 * <p>
 */

public class BasicCalculator {

    // time complexity is O(n)
    // space complexity is O(n)
    public static void main(String[] args) {
        var basicCalculator = new BasicCalculator();
        System.out.println(
                basicCalculator.calculate("(1+(4+5+2)-3)+(6+8)")
        );
    }

    // s is in infix notation
    public int calculate(String s) {
        s = s.replaceAll("\\s+", "");
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException ex) {
            // ignore
        }
        // convert infix notation to reverse polish notation (postfix)
        var postfix = postfix(s);
        System.out.println(postfix);
        return calculatePostfix(postfix);
    }

    private int calculatePostfix(List<String> postfix) {
        var stack = new Stack<Integer>();
        for (String value : postfix) {
            try {
                stack.push(Integer.parseInt(value));
            } catch (NumberFormatException ex) {
                int second = stack.pop();
                int first = stack.pop();
                stack.push(
                        operation(first, second, value)
                );
            }
        }

        return stack.pop();
    }

    private int operation(int first, int second, String operator) {
        return switch (operator) {
            case "+" -> first + second;
            case "-" -> first - second;
            case "*" -> first * second;
            case "/" -> first / second;
            default -> 0;
        };
    }

    public List<String> postfix(String s) {
        var postfix = new ArrayList<String>();
        var stack = new Stack<Character>();
        var data = s.toCharArray();
        String digit = "";
        for (int i = 0; i < data.length; i++) {
            char ch = data[i];
            if (Character.isDigit(ch)) {
                digit = digit.concat(Character.toString(ch));
            } else {
                if (!digit.isEmpty()) {
                    postfix.add(digit);
                    digit = "";
                }

                if (isOperator(ch)) {
                    if (ch == '-' && (i == 0 || isOperator(data[i - 1]) || data[i - 1] == '(')) {
                        postfix.add("0");
                    }

                    while (!stack.isEmpty() &&
                            precedence(stack.peek()) >= precedence(ch) &&
                            precedence(ch) != -1) {
                        postfix.add(Character.toString(stack.pop()));
                    }
                    stack.push(ch);
                } else if (ch == '(') {
                    stack.push(ch);
                } else if (ch == ')') {
                    char top;
                    while (!stack.isEmpty() && (top = stack.pop()) != '(') {
                        postfix.add(Character.toString(top));
                    }
                }
            }
        }

        if (!digit.isEmpty())
            postfix.add(digit);

        while (!stack.isEmpty()) {
            postfix.add(Character.toString(stack.pop()));
        }

        return postfix;
    }

    public boolean isOperator(char operator) {
        return operator == '-' ||
                operator == '+' ||
                operator == '*' ||
                operator == '/';
    }

    private int precedence(char operator) {
        return switch (operator) {
            case '/', '*' -> 1;
            case '+', '-' -> 0;
            default -> -1;
        };
    }
}
