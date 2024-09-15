package org.algorithms.io.arrays;

import java.util.Arrays;

public class StudentNotInRightOrder {
    public static void main(String[] args) {
        System.out.println(
                studentsNotInRightOrder(
                        new int[] {
                                4, 3, 2, 1
                        }
                )
        );
    }

    public static int studentsNotInRightOrder(int []students) {
        int count = 0;
        int []original = Arrays.copyOf(students, students.length);
        Arrays.sort(students);

        for(int i = 0; i < original.length; i++) {
            if(original[i] != students[i])
                count++;
        }

        return count;
    }
}
