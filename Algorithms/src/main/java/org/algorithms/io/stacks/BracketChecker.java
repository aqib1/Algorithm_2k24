package org.algorithms.io.stacks;

import java.util.HashMap;
import java.util.Stack;

public class BracketChecker {
    public static void main(String[] args) {
        var checker = new BracketChecker();

        System.out.println(checker.isValid("()[]{}}"));
    }

    // O(n) time + O(n) space
    public boolean isValid(String s) {
        char[] brackets = s.toCharArray();
        // O(3) space
        var bracketPairs = new HashMap<Character, Character>();
        bracketPairs.put(']', '[');
        bracketPairs.put('}', '{');
        bracketPairs.put(')', '(');
        var stack = new Stack<Character>();
        var closingKeys = bracketPairs.keySet();
        for(char bracket: brackets) {
            if(closingKeys.contains(bracket)) {
                if(stack.isEmpty() || stack.pop() !=bracketPairs.get(bracket)) {
                    return false;
                }
            } else {
                stack.push(bracket);
            }
        }

        return stack.isEmpty();
    }
}
