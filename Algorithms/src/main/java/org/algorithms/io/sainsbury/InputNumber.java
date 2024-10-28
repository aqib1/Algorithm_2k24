package org.algorithms.io.sainsbury;

import java.util.ArrayList;
import java.util.List;

public class InputNumber {
    public static void main(String[] args) {
        System.out.println(generateNumber(1));
    }
    public static List<String> generateNumber(int n) {
        var response = new ArrayList<String>();
        generateNumber("", 1, n, response);
        return response;
    }

    public static void generateNumber(String current, int start, int limit, ArrayList<String> response) {
        if(limit == 0) {
            response.add(current);
        } else {

            for(int i = start; i <= 9; i++) {
                generateNumber(current + i, i, limit - 1, response);
            }
        }
    }
}
