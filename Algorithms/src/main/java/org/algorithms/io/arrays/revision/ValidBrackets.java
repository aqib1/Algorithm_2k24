package org.algorithms.io.arrays.revision;

import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

public class ValidBrackets {
    private static final Map<Character, Character> PARAM_PAIR = Map.of(
            '}', '{',
            ']', '[',
            ')', '('
    );

    // Time complexity O(n) and space complexity O(n)
    public boolean isValid(String s) {
        var stack = new Stack<Character>();
        var openingParam = new HashSet<>(PARAM_PAIR.values());
        for (char ch : s.toCharArray()) {
            if (PARAM_PAIR.containsKey(ch)) {
                if (stack.isEmpty() || PARAM_PAIR.get(ch) != stack.pop()) {
                    return false;
                }
            } else if (openingParam.contains(ch)) {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        var validParam = new ValidBrackets();
        System.out.println(validParam.isValid("()[d({(a)c})]"));
    }
}
