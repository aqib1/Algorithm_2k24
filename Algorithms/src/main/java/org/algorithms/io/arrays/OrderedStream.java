package org.algorithms.io.arrays;

import java.util.ArrayList;
import java.util.List;

public class OrderedStream {
    private int crPtr = 0;
    private String[] orderedStream;

    public OrderedStream(int n) {
        orderedStream = new String[n];
    }

    public List<String> insert(int idKey, String value) {
        var stream = new ArrayList<String>();
        var index = idKey - 1;
        orderedStream[index] = value;
        if (index != crPtr) {
            return stream;
        }
        for (int i = crPtr; i < orderedStream.length && orderedStream[i] != null; i++) {
            stream.add(orderedStream[i]);
            crPtr++;
        }
        return stream;
    }


    public static void main(String[] args) {
        var orderedStream = new OrderedStream(5);

        System.out.println(orderedStream.insert(3, "ccccc"));
        System.out.println(orderedStream.insert(1, "aaaaa"));
        System.out.println(orderedStream.insert(2, "bbbbb"));
        System.out.println(orderedStream.insert(5, "eeeee"));
        System.out.println(orderedStream.insert(4, "ddddd"));
    }
}
