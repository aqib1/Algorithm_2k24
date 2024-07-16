package org.algorithms.io.meta;

import java.util.Stack;

public class MinRemoveToMakeValid {
    public static void main(String[] args) {
        var min = new MinRemoveToMakeValid();
        System.out.println(
                min.makeRemoveToMakeValidUsingStack(
                        "a)b(c)d"
                )
        );
    }

    // Time complexity O(n)
    // Space complexity O(n)
    public String makeRemoveToMakeValidUsingStack(String s) {
        var response = new StringBuilder();
        var stack = new Stack<Character>();
        for(char ch : s.toCharArray()) {
            if(ch == ')' && stack.isEmpty()) {
                continue;
            } else {
                response.append(ch);
            }

            if(ch == '(') stack.push(ch);
            if(ch == ')') stack.pop();

        }

        for(int x=response.length() - 1; x>=0 && !stack.isEmpty(); x--) {
            if(stack.peek() == response.charAt(x)) {
                response.deleteCharAt(x);
                stack.pop();
            }
        }
        return response.toString();
    }

    // Time complexity O(n)
    // Space complexity O(n)
    public String minRemoveToMakeValid(String s) {
        int paramCount = 0;
        var response = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                paramCount++;
            } else if(s.charAt(i) == ')') {
                paramCount--;
            }

            if(paramCount < 0) {
                paramCount = 0;
            } else {
                response.append(s.charAt(i));
            }
        }

        paramCount = 0;
        for(int i = response.length() - 1; i >= 0; i--) {
            if(response.charAt(i) == ')') {
                paramCount++;
            } else if(response.charAt(i) == '(') {
                paramCount--;
            }

            if(paramCount < 0) {
                paramCount = 0;
                response.deleteCharAt(i);
            }
        }
        return response.toString();
    }
}
