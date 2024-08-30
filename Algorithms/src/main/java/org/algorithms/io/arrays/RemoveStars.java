package org.algorithms.io.stacks;

import java.util.Stack;
import java.util.stream.Collectors;

public class RemoveStars {

    public static void main(String[] args) {
        System.out.println(
                removeStars("leet**cod*e")
        );
    }

    /*
    * Input: s = "leet**cod*e"
      Output: "lecoe"
    * */

    // Time complexity O(n)
    // Space complexity O(n)
    public static String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()) {
            if(ch == '*') {
                stack.pop();
            } else {
                stack.push(ch);
            }

        }

        return stack.stream().map(Object::toString).collect(Collectors.joining(""));
    }
}
