package org.algorithms.io.strings;

public class IsSubsequence {

    public static void main(String[] args) {
        var isSubsequence = new IsSubsequence();

        System.out.println(
                isSubsequence.isSubsequence(
                        "abc",
                        "ahbgdc"
                )
        );
    }

    /**
     * Input: s = "abc", t = "ahbgdc"
     * Output: true
     */
    public boolean isSubsequence(String s, String t) {
        if (s.isBlank())
            return true;
        int st = 0;
        char[] sData = s.toCharArray();
        char[] tData = t.toCharArray();
        for (char tDatum : tData) {
            if (sData[st] == tDatum) {
                st++;
            }

            if (st == sData.length) return true;
        }
        return false;
    }
}
