package org.algorithms.io.strings;

import java.util.Set;

public class ReverseVowels {

    public static void main(String[] args) {
        var reverse = new ReverseVowels();

        System.out.println(reverse.reverseVowels("hello"));
    }

    // Time complexity O(N)
    // Space complexity O(1)
    public String reverseVowels(String s) {
        int i = 0, j = s.length() - 1;
        char[] data = s.toCharArray();
        while (i < j) {
            if (isVowel(data[i]) && isVowel(data[j])) {
                swap(data, i, j);
                i++;
                j--;
            }

            if (!isVowel(data[i])) {
                i++;
            }
            if (!isVowel(data[j])) {
                j--;
            }
        }

        return String.valueOf(data);
    }

    private void swap(char[] data, int i, int j) {
        var tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public boolean isVowel(char ch) {
        var vowels = Set.of(
                'a',
                'e',
                'i',
                'o',
                'u',
                'A',
                'E',
                'I',
                'O',
                'U'
        );

        return vowels.contains(ch);
    }
}
