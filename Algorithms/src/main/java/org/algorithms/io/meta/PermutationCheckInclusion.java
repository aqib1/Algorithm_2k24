package org.algorithms.io.meta;

public class PermutationCheckInclusion {
    public static void main(String[] args) {
        System.out.println(
                checkInclusion(
                        "adc",
                        "dcda"
                )
        );
    }
    public static boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        for(int i = 0; i <= s2.length() - s1Len; i++) {
           var sub = s2.substring(i, i + s1Len);
           if(checkPermutation(s1, sub)) {
                return true;
           }
        }
        return false;
    }

    private static boolean checkPermutation(String s1, String s2) {
        int[] count = new int[26];
        for(char c: s1.toCharArray()) {
            count[c - 'a']++;
        }

        for(char c: s2.toCharArray()) {
            count[c - 'a']--;
        }

        for(int i : count)
            if(i != 0)
                return false;

        return true;
    }
}
