package org.algorithms.io.generics;

// Bounded type

public class StringDataType <T extends String> {

    public String add(T t1, T t2) {
        return t1.concat(t2);
    }
}
