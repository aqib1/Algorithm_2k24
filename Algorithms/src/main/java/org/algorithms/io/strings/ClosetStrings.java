package org.algorithms.io.strings;

import java.util.Arrays;

public class ClosetStrings {

    public static void main(String[] args) {
        System.out.println(('z' - 'a'));
    }

    // Time complexity O (N * Log(N))
    // Space complexity O(52) = O(1)
    public boolean closeStrings(String word1, String word2) {
        int[] frequency1 = new int[26];
        int[] frequency2 = new int[26];

        for (char c : word1.toCharArray()) {
            frequency1[c - 'a']++;
        }

        for (char c : word2.toCharArray()) {
            frequency2[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (frequency1[i] == 0 && frequency2[i] != 0 ||
                    frequency1[i] != 0 && frequency2[i] == 0)
                return false;
        }

        Arrays.sort(frequency1);
        Arrays.sort(frequency2);

        for (int x = 0; x < 26; x++) {
            if (frequency1[x] != frequency2[x])
                return false;
        }

        return true;
    }
}
