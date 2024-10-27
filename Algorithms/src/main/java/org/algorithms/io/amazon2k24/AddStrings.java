package org.algorithms.io.strings;

public class AddStrings {
    public static void main(String[] args) {
        System.out.println(addStrings("11", "123"));
    }

    public static String addStrings(String num1, String num2) {
        var add = new StringBuilder();
        var i = num1.length() - 1;
        var j = num2.length() - 1;
        var carry = 0;
        while (i >= 0 || j >= 0) {
            var n1 = i < 0 ? 0 : num1.charAt(i) - '0';
            var n2 = j < 0 ? 0 : num2.charAt(j) - '0';
            var sum = (n1 + n2) + carry;
            add.insert(0, sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }
        if (carry != 0) add.insert(0, carry);

        return add.toString();
    }
}
