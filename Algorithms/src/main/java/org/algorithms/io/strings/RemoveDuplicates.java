package org.algorithms.io.strings;

import java.util.Stack;

public class RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }

    public static String removeDuplicatesFaster(String s) {
        char []response = new char[s.length()];
        int pointer = -1;
        for(char c: s.toCharArray()) {
            if(pointer > -1 && response[pointer] == c) {
                pointer--;
            } else {
                pointer++;
                response[pointer] = c;
            }
        }

        return new String(response, 0, pointer + 1);
    }

    public static String removeDuplicates(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(Character ch: s.toCharArray()) {
            if(!stack.isEmpty() && stack.peek() == ch) stack.pop();
            else
                stack.push(ch);
        }


        for(int i = 0; i < stack.size(); i++) {
            res.append(stack.get(i));
        }

        return res.toString();
    }


}
