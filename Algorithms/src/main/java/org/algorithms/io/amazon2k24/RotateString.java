package org.algorithms.io.amazon2k24;

import java.util.Objects;

public class RotateString {
    public static void main(String[] args) {
        System.out.println(
                rotateString("bbbacddceeb", "ceebbbbacdd")
        );
    }

    public static boolean rotateString(String s, String goal) {
        if(Objects.isNull(s) || Objects.isNull(goal)
                || s.isEmpty() || goal.isEmpty()
                || s.length() != goal.length()) {
            return false;
        }

        return s.concat(s).contains(goal);
    }
}
