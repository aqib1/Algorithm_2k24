package org.algorithms.io.amazon2k24;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    // Time complexity O(n)
    // Space complexity O(n)
    public List<String> fizzBuzz(int n) {
        var response = new ArrayList<String>();

        for(int i = 1; i <= n; i++) {
            if(i % 3 == 0 && i % 5 == 0) {
                response.add("FizzBuzz");
            } else if(i % 3 == 0) {
                response.add("Fizz");
            } else if(i % 5 == 0) {
                response.add("Buzz");
            } else {
                response.add(String.valueOf(i));
            }
        }

        return response;
    }
}
