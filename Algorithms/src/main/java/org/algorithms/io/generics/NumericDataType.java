package org.algorithms.io.generics;

public class NumericDataType<T extends Number> implements DataType<T> {
    @Override
    public void addition(T a, T b) {
        System.out.println("Adding 2 generic instances");
        System.out.printf(
                "The result is: {%s}",
                a.doubleValue() + b.doubleValue()
        );
    }

    @Override
    public void subtraction(T a, T b) {
        System.out.println("Subtracting 2 generic instances");
        System.out.printf("The result is: {%s}",
                a.doubleValue() - b.doubleValue()
        );
    }

    @Override
    public void multiplication(T a, T b) {
        System.out.println("Multiplying 2 generic instances");
        System.out.printf("The result is: {%s}",
                a.doubleValue() * b.doubleValue()
        );
    }

    @Override
    public void division(T a, T b) {
        System.out.println("Dividing 2 generic instances");
        System.out.printf("The result is: {%s}",
                a.doubleValue() / b.doubleValue()
        );
    }

    @Override
    public void performAll(T a, T b) {
        addition(a, b);
        subtraction(a, b);
        division(a, b);
        multiplication(a, b);
    }
}
