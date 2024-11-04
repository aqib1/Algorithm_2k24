package org.algorithms.io.amazon2k24;

public class IsCircularSentence {
    public static void main(String[] args) {
        System.out.println(isCircularSentence(
                "a"
        ));
    }
    public static boolean isCircularSentence(String sentence) {
        if(sentence.isEmpty())
            return false;
        var words = sentence.split(" ");
        for(int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            if(w1.charAt(w1.length() - 1) != w2.charAt(0)) {
                return false;
            }
        }

        return words[0].charAt(0) == words[words.length - 1].charAt(words[words.length - 1].length() - 1);
    }
}
