package org.algorithms.io.amazon2k24;

public class LongestWithRepeating {


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }

    /*
    *
    * Input: s = "abcdefggcbb"
     Output: 3
        Explanation: The answer is "abc", with the length of 3.
    * Constraints:

       - 0 <= s.length <= 5 * 104
       - s consists of English letters, digits, symbols and spaces.
    * */

    //abcdefdgcbb
    public static int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0;
        int limit = s.length();
        var response = 0;
        var countMap = new int[256];

        while(start < limit && end < limit) {
            if(countMap[s.charAt(end)] == 0) {
                response = Math.max(response, (end - start) + 1);
                countMap[s.charAt(end++)]++;
            } else {

                countMap[s.charAt(start++)]--;
            }
        }
        return response;
    }
}
