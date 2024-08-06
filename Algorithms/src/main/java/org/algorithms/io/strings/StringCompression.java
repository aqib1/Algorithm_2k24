package org.algorithms.io.strings;

import java.util.ArrayList;
import java.util.Arrays;

public class StringCompression {

    public static void main(String[] args) {
        var sc = new StringCompression();
        var str = new char[]{
                'a','a','a','b','b','a','a'
        };
        System.out.println(sc.compress(
                       str
                )
        );

        System.out.println(Arrays.toString(str));
    }

    // Time complexity O(N) + O(N) = O2(N) = O(N)
    // Space complexity O(N)
    public int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }

        var result = new ArrayList<Character>(chars.length);
        int count = 1;
        for (int x = 0; x < chars.length; x++) {
            if(x == chars.length - 1) {
                result.add(chars[x]);
                addCountGreaterThanOne(count, result);
            } else if(chars[x] == chars[x + 1]) {
                count++;
            } else {
                result.add(chars[x]);
                addCountGreaterThanOne(count, result);
                count = 1;
            }
        }

        for(int i = 0; i < result.size(); i++) {
            chars[i] = result.get(i);
        }
        return result.size();
    }

    private void addCountGreaterThanOne(int count, ArrayList<Character> result) {
        if(count > 1) {
            result.addAll(String.valueOf(count)
                    .chars().mapToObj(i -> (char) i).toList());
        }
    }
}
