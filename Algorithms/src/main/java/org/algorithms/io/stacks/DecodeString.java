package org.algorithms.io.stacks;

import java.util.Stack;

public class DecodeString {

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
    }

    public static String decodeString(String s) {
        var stack = new Stack<Character>();
        var response = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ']') {
                var subStr = new StringBuilder();

                while(!stack.isEmpty() && stack.peek() != '[') {
                    subStr.insert(0, stack.pop());
                }

                stack.pop();

                var num = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    num.insert(0, stack.pop());
                }

                if(!num.isEmpty()) {
                    var multiple = multiplyString(
                            subStr.toString(),
                            Integer.parseInt(num.toString())
                    );

                    for(char c: multiple.toCharArray()) {
                        stack.push(c);
                    }
                }

            } else  {
                stack.push(s.charAt(i));
            }
        }

        while(!stack.isEmpty()) {
            response.insert(0, stack.pop());
        }

        return response.toString();
    }

    public static String multiplyString(
            String value,
            int n
    ) {
        return value.repeat(Math.max(0, n));
    }
}
