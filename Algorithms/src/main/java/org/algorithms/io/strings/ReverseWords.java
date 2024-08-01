package org.algorithms.io.strings;

import java.util.LinkedList;

public class ReverseWords {
    public static void main(String[] args) {
        var reverse = new ReverseWords();

        System.out.println(reverse.reverseWords(
                "a good   example"
        ));
    }

    // Time complexity O(N) where N are words in a statement
    // Space complexity O(N) for LinkedList and O(N) for StringBuilder
    // where N are words in a statement so it O2(N) = O(N)
    public String reverseWords(String s) {
        String[] splits = s.split(" ");
        var linkedList = new LinkedList<String>();
        var builder = new StringBuilder();

        for (var data : splits) {
            if (!data.isBlank())
                // O(1)
                linkedList.push(data.trim());
        }

        while (!linkedList.isEmpty()) {
            // O(1)
            builder.append(linkedList.pop()).append(" ");
        }
        return builder.toString().trim();
    }
}
