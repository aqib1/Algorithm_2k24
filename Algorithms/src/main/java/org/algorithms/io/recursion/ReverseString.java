package org.algorithms.io.recursion;

public class ReverseString {
    public static void main(String[] args) {
        var reverse = new ReverseString();
        System.out.println(reverse.reverseOneLinear("Kevin"));
    }

    public String reverseOneLinear(String s) {
        if(s.isEmpty()) return s;

        return reverseOneLinear(s.substring(1)) + s.charAt(0);
    }

    public String reverse(String s) {
        return reverseTailRecursion(s, "", s.length() - 1);
    }

    public String reverseTailRecursion(
            String input,
            String accum,
            int index) {
        if(index < 0) {
            return accum;
        }

        return reverseTailRecursion(
                input,
                accum + input.charAt(index),
                index - 1
        );
    }

    // Head recursion
    public String reverseBacktracking(String input, String output, int index) {
        if(index >= input.length()) {
            return output;
        }
        var result = reverseBacktracking(input, output, index + 1);
        result += input.charAt(index);
        return result;
    }
}
