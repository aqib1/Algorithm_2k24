package org.algorithms.io.strings;

public class ValidPalindromeAfterDeletingOne {

    public static void main(String[] args) {
        System.out.println(validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga" ));
    }

    // Time complexity O(M * N) -> O(n2) worst-case scenario 
    // O(N) is best case
    // space O(1)
    public static boolean validPalindrome(String s) {
        char[] sData = s.toCharArray();
        return isPalindrome(sData, 0, sData.length - 1, false);
    }

    private static boolean isPalindrome(char[] sData, int start, int end, boolean deleted) {
        while (start < end) {
            if (sData[start] != sData[end]) {
                if (deleted) return false;
                return isPalindrome(sData, start + 1, end, true) ||
                        isPalindrome(sData, start, end - 1, true);
            }
            start++;
            end--;
        }

        return true;
    }

}
