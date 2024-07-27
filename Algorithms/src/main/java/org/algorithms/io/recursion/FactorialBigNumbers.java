package org.algorithms.io.recursion;

import java.math.BigInteger;
import java.util.Objects;

public class FactorialBigNumbers {

    public static void main(String[] args) {
        var factorial  = new FactorialBigNumbers();

        System.out.println(factorial.factorial(BigInteger.valueOf(10)));
    }

    public BigInteger factorial(BigInteger value) {
        if(Objects.equals(value, BigInteger.ZERO))
            return BigInteger.ONE;

        return value.multiply(factorial(value.subtract(BigInteger.ONE)));
    }

}
