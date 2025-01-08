package org.algorithms.io.revision;

import java.util.ArrayList;
import java.util.List;

public class AllIndicesOfOccurrence {
    public static void main(String[] args) {
        System.out.println(findAll("aabaacaadaabaaba", "aaba"));
    }
    public static List<Integer> findAll(String text, String pat) {
        int [] patLps = lps(pat);
        var response = new ArrayList<Integer>();
        int patPtr = 0;
        int textPtr = 0;
        while(textPtr < text.length()) {
            if(text.charAt(textPtr) == pat.charAt(patPtr)) {
                textPtr++;
                patPtr++;

                if(patPtr == pat.length()) {
                    response.add(textPtr - patPtr);
                    patPtr = patLps[patPtr - 1];
                }
            } else {
                if(patPtr == 0) {
                    textPtr++;
                } else {
                    patPtr = patLps[patPtr - 1];
                }
            }
        }

        return response;
    }

    private static int[] lps(String pat) {
        int [] lps = new int[pat.length()];
        int len = 0;
        int j = 1;

        while(j < pat.length()) {
            if(pat.charAt(len) == pat.charAt(j)) {
                lps[j++] = ++len;
            } else {
                if(len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[j++] = 0;
                }
            }
        }

        return lps;
    }
}
