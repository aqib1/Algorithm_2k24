package org.algorithms.io.number;

import java.util.Scanner;

public class SumOf2Digits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        while(tests > 0) {
            System.out.println(
                    sum(scanner.nextInt())
            );
            tests--;
        }

        scanner.close();
    }
    public static int sum(int number) {
        return (number / 10) + (number % 10);
    }
}
