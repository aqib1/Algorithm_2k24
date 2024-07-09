package org.algorithms.io.stacks;

import java.util.Stack;
import java.util.stream.IntStream;

public class ReverseWords {

    public String reverseWords(String s) {
        s = s.trim();
        String[] words = s.split(" ");
        var stack = new Stack<String>();
        IntStream.range(0, words.length)
                .filter(i -> !words[i].isBlank())
                .forEach(i -> stack.push(words[i]));
        var result = new StringBuilder();
        while(!stack.isEmpty()) {
            result.append(stack.pop()).append(" ");
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        var reverseWords = new ReverseWords();

        System.out.println(reverseWords.reverseWords("a good   example"));
    }
}
