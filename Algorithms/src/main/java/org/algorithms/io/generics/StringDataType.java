package org.algorithms.io.generics;

public class StringDataType<T extends String> implements DataType<T> {

    @Override
    public void addition(T a, T b) {
        System.out.println("Adding two strings");
        System.out.printf("The result is: {%s}%n", a.concat(b));
    }

    @Override
    public void subtraction(T a, T b) {
        System.out.println("Can't perform this operation on strings");
    }

    @Override
    public void multiplication(T a, T b) {
        System.out.println("Can't perform this operation on strings");
    }

    @Override
    public void division(T a, T b) {
        System.out.println("Can't perform this operation on strings");
    }

    @Override
    public void performAll(T a, T b) {
        addition(a, b);
        subtraction(a, b);
        division(a, b);
        multiplication(a, b);
    }
}
