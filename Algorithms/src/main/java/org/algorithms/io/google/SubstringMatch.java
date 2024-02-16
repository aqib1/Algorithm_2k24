package org.algorithms.io.google;

public class SubstringMatch {
    public static void main(String[] args) {
        System.out.println(
                hasMatch(
                        "xxxxqzq", "qzq*qz"
                )
        );
    }
    /**
     * You are given a string s and a pattern string p, where p contains exactly one '*' character.
     * The '*' in p can be replaced with any sequence of zero or more characters.
     * Return true if p can be made a
     * substring
     * of s, and false otherwise.
     *
     * Time complexity O(2) as loop will always be 2 iteration and space is O(2)
     */
    public static boolean hasMatch(String s, String p) {
        var ps = p.split("\\*");
        var psIndex = 0;
        var start = 0;

        while (start < s.length() && psIndex < ps.length) {
            var i = s.indexOf(ps[psIndex], start);
            if (i == -1) return false;
            start = i + ps[psIndex++].length();
        }
        return psIndex == ps.length;
    }
}
