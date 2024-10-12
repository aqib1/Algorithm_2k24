package org.algorithms.io.strings;

import java.util.HashSet;

public class PartitionString {
    public static void main(String[] args) {
        System.out.println(
                partitionString("abacaba")
        );
    }
    public static int partitionString(String s) {
        int count = 0;
        var set = new HashSet<Integer>(26);

        for(char c: s.toCharArray()) {
            var ch = c - 'a';
            if(set.contains(ch)) {
                count++;
                set.clear();
            }
            set.add(ch);
        }

        if(!set.isEmpty()) count++;

        return count;
    }
}
