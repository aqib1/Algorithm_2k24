package org.algorithms.io.map;


public class ConstructKPalindromeString {
    public static void main(String[] args) {
        var c = new ConstructKPalindromeString();
        System.out.println(
                c.canConstruct("yzyzyzyzyzyzyzy", 2)
        );
    }
    public boolean canConstruct(String s, int k) {
        if(s.length() < k)
            return false;
        var chCount = new char[26];
        var data = s.toCharArray();
        for(char ch: data) chCount[ch - 'a']++;
        var oddFreqCount = 0;

        for (char c : chCount) if (c % 2 != 0) oddFreqCount++;

        return oddFreqCount <= k;
    }
}
