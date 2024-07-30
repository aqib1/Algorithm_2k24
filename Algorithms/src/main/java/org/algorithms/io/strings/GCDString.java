package org.algorithms.io.strings;

public class GCDString {

    public static void main(String[] args) {
        var gcd = new GCDString();

        System.out.println(gcd.gcdOfStrings("ABABAB", "ABAB"));
    }

    public String gcdOfStrings(String str1, String str2) {
        if(!str1.concat(str2).equalsIgnoreCase(str2.concat(str1))) {
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    // Euclidean Algorithm
    private int gcd(int a, int b) {
        if(b == 0)
            return a;

        return gcd(b, a % b);
    }
}
