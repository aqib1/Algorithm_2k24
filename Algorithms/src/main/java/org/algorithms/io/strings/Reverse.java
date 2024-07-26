package org.algorithms.io.strings;

public class Reverse {
    public static void main(String[] args) {
        var r = new Reverse();
        System.out.println(r.reverse(964));
    }

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
