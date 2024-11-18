package org.algorithms.io.amazon2k24;

public class UniqueLetterString {
    public static void main(String[] args) {
        System.out.println(uniqueLetterStringBruteForce("LEETCODE"));
    }
    
    // O(n3)
    // space O(26) 
    public static int uniqueLetterStringBruteForce(String s) {
        int n = s.length();
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j <= n; j++) {
                count += uniqueLetters(s.substring(i, j));
            }
        }

        return count;
    }

    private static int uniqueLetters(String substring) {
        int []count = new int[26];
        int result = 0;

        for(char c: substring.toCharArray()) {
            count[c - 'A']++;
        }

        for(int i = 0; i < 26; i++) {
            if(count[i] == 1) {
                result++;
            }
        }

        return result;
    }
}
