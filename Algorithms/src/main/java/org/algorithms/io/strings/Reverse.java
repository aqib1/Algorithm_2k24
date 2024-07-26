package org.algorithms.io.strings;

public class Reverse {
    public static void main(String[] args) {
        var r = new Reverse();
        System.out.println(r.reverse(964));
    }

    // Space complexity O(1)
    // Time complexity OLog(N)
    public int reverseOptimal(int x) {
        long reverse = 0;
        while(x != 0) {
            reverse = (reverse * 10) + (x % 10);
            if(reverse < Integer.MIN_VALUE || reverse > Integer.MAX_VALUE)
                return 0;
            x /= 10;
        }
       return (int)reverse;
    }

    // Time complexity O(N)
    // Space complexity O(N)
    public int reverse(int x) {
        var strInteger = Long.toString(x);
        var isNegative = false;
        if (strInteger.startsWith("-")) {
            isNegative = true;
            strInteger = strInteger.substring(1);
        }
        var reversed = new StringBuilder(strInteger).reverse();
        if (isNegative) strInteger = "-" + reversed;
        else strInteger = reversed.toString();

        var result = Long.parseLong(strInteger);

        if(result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return 0;
        }

        return (int) result;
    }
}
