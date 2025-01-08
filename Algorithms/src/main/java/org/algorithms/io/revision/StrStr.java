package org.algorithms.io.revision;

import java.util.Arrays;

public class StrStr {
    public static void main(String[] args) {
//        System.out.println(strString("mississippi", "issip"));
        System.out.println(longestPrefixSuffix("aacdaacd"));
    }

    static int longestPrefixSuffix(String s) {
        // using KMP
        int []lps = new int[s.length()];
        int len = 0;
        int j = 1;
        while(j < s.length()) {
            if(s.charAt(len) == s.charAt(j)) {
                lps[j++] = ++len;
            } else {
                if(len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[j++] = 0;
                }
            }
        }

        System.out.println(Arrays.toString(lps));

        return lps[lps.length - 1];
    }

    // Input: haystack = "sabdbutsad", needle = "saad"
    // Output: 0
    // Explanation: "sad" occurs at index 0 and 6.
    // The first occurrence is at index 0, so we return 0.
    public static int strString(String haystack, String needle) {
        if(needle.length() > haystack.length())
            return -1;
        int []needleLps = new int[needle.length()];
        int len = 0;
        int i = 1;
        while(i < needle.length()) {
            if(needle.charAt(len) == needle.charAt(i)) {
                needleLps[i++] = ++len;
            } else {
                if (len != 0) {
                    len = needleLps[len - 1];
                } else {
                    needleLps[i++] = 0;
                }
            }
        }

        int needlePtr = 0;
        int haystackPtr = 0;

        // ababdeababc // ababc
        while(haystackPtr < haystack.length()) {
            if(haystack.charAt(haystackPtr) == needle.charAt(needlePtr)) {
                haystackPtr++;
                needlePtr++;

                if(needlePtr == needle.length())
                    return haystackPtr - needlePtr;
            } else {
             if(needlePtr == 0) {
                 haystackPtr++;
             } else {
                 needlePtr = needleLps[needlePtr - 1];
             }
            }
        }

        return -1;

    }

  // abcdabcd
    public static int[] lps(String pattern) {
        // LPS table (longest Prefix Suffix table)
        int [] piTable = new int[pattern.length()];
        int i = 1;
        int len = 0;

        while(i < pattern.length()) {
            if(pattern.charAt(i) == pattern.charAt(len)) {
                piTable[i] = ++len;
                i++;
            } else {
                if(len != 0) {
                    len = piTable[len - 1];
                } else {
                    piTable[i++] = 0;
                }
            }
        }


        return piTable;
    }

    // Input: haystack = "sabdbutsad", needle = "sad"
    // Output: 0
    // Explanation: "sad" occurs at index 0 and 6.
    // The first occurrence is at index 0, so we return 0.
    public static int strStr(String haystack, String needle) {
       for(int i = 0; i < haystack.length(); i++) {
           int k = i;
           for(int j = 0; j < needle.length() && k < haystack.length(); j++) {
               if(haystack.charAt(k) != needle.charAt(j)) {
                   break;
               }
               k++;
           }
           if((k - i) == needle.length())
               return i;
       }

       return -1;
    }
}
