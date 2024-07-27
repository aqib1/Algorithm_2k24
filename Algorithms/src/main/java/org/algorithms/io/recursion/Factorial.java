package org.algorithms.io.recursion;

public class Factorial {

    public static void main(String[] args) {
        var factorial  = new Factorial();

        System.out.println(factorial.factorial(9));
    }

    public int factorial(int value) {
        if(value == 0)
            return 1;

        return value * factorial(value - 1);
    }

}
