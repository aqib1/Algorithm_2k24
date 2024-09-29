package org.algorithms.io.generics;

public interface DataType<T> {
    void addition(T a, T b);
    void subtraction(T a, T b);
    void multiplication(T a, T b);
    void division(T a, T b);
    void performAll(T a, T b);
}
