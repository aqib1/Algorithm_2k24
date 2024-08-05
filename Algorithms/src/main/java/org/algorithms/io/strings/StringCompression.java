package org.algorithms.io.strings;

import java.util.ArrayList;
import java.util.HashMap;

public class StringCompression {

    //["a","3","b","2","a","2"]
    public static void main(String[] args) {
        var sc = new StringCompression();

        System.out.println(sc.compress(
                        new char[]{
                                'a','a','a','b','b','a','a'
                        }
                )
        );
    }

    public int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }

        var result = new ArrayList<Character>(chars.length);
        var charByCount = new HashMap<Character, Integer>();
        for (char aChar : chars) {
            charByCount.merge(aChar, 1, Integer::sum);
        }

        for (char aChar : charByCount.keySet()) {
            result.add(aChar);
            var count = charByCount.get(aChar);
            if(count > 1) {
                result.addAll(String.valueOf(count)
                        .chars().mapToObj(i -> (char) i).toList());
            }

        }

        for(int i = 0; i < result.size(); i++) {
            chars[i] = result.get(i);
        }
        return result.size();
    }
}
