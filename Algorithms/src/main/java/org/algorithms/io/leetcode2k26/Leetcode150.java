package org.algorithms.io.leetcode2k26;

import java.util.Arrays;
import java.util.Set;
import java.util.Stack;

public class Leetcode150 {

    public static void main(String[] args) {
        var leetcode = new Leetcode150();
        System.out.println(
                leetcode.evalRPN(
                        new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"}
                )
        );
    }

    private static final Set<String> OPERATORS = Set.of(
            "+", "-", "*", "/"
    );

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length <= 2) {
            throw new IllegalArgumentException("Tokens are invalid");
        }
        var stack = new Stack<Integer>();
        Arrays.stream(tokens).forEach(
                t -> {
                    if(OPERATORS.contains(t)) {
                        stack.push(performOperation(t, stack.pop(), stack.pop()));
                    } else {
                        stack.push(Integer.parseInt(t));
                    }
                });

        return stack.pop();
    }

    private int performOperation(String t, int pop, int pop1) {
        return switch (t) {
            case "+" -> pop + pop1;
            case "-" -> pop1 - pop;
            case "*" -> pop * pop1;
            case "/" -> pop1 / pop;
            default -> throw new IllegalArgumentException("Operation is invalid");
        };
    }
}
