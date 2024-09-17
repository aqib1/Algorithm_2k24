package org.algorithms.io.generics;

import java.math.BigDecimal;

public class NumberDataType<T extends Number> {
    public static void main(String[] args) {
        var n = new NumberDataType<Integer>();
        System.out.println(n.add(1, 33));
    }
    public BigDecimal add(T t1, T t2) {
        return BigDecimal.valueOf(
                t1.doubleValue()
        ).add(BigDecimal.valueOf(t2.doubleValue()));
    }
}
