package org.algorithms.io.amazon2k24;

public class StringCompressionIII {
    public static void main(String[] args) {
        System.out.println(
                compressedString("aaaaaaaaay")
        );
    }

    // O(k*2) space where k is unique characters + O(n) time
    public static String compressedString(String word) {
        if(word.isEmpty())
            return "";

        var wordData = word.toCharArray();
        StringBuilder compressed = new StringBuilder();
        int position = 0;
        while(position < wordData.length) {
            int count = 0;
            var current = wordData[position];
            while(position < wordData.length
                    && current == wordData[position]
                        && count < 9) {
                count++;
                position++;
            }
            compressed.append(count).append(current);
        }

        return compressed.toString();
    }
}
