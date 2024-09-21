package org.algorithms.io.map;

public class ShortestCompletingWords {

    public static void main(String[] args) {
        System.out.println(
                shortestCompletingWordBetter(
                        "1s3 456",
                        new String[] {"looks","pest","stew","show"}
                )
        );
    }



    public static String shortestCompletingWordBetter(String licensePlate, String[] words) {
        var countLicense = new int[26];
        for(char ch: licensePlate.toCharArray()) {
            if(ch >= 'a' && ch <= 'z') {
                countLicense[ch - 'a']++;
            }

            if(ch >= 'A' && ch <= 'Z') {
                countLicense[ch - 'A']++;
            }
        }

        int minLength = Integer.MAX_VALUE;
        var response = "";

        for(var word: words) {
            if(word.length() < minLength && isCompleteWord(word, countLicense)) {
                minLength = word.length();
                response = word;
            }
        }

        return response;
    }

    private static boolean isCompleteWord(String word, int[] countLicense) {
        var wordCharCount = new int[26];
        for(char ch: word.toCharArray()) {
            if(ch >= 'a' && ch <= 'z') {
                wordCharCount[ch - 'a']++;
            }
        }

        for(int x = 0; x < wordCharCount.length; x++) {
            if(wordCharCount[x] < countLicense[x])
                return false;
        }

        return true;
    }


    public static String shortestCompletingWord(String licensePlate, String[] words) {
        var licensePlateCharCount = new int[256];
        licensePlate = licensePlate.toLowerCase();
        for(char c: licensePlate.toCharArray()) {
            if(c >= 'a' && c <= 'z')
                licensePlateCharCount[c]++;
        }

        var maxMatch = 0;
        var shortestLen = Integer.MAX_VALUE;
        String response = "";
        for(var word: words) {
            word = word.toLowerCase();
            var bestMatch = bestMatch(word.toCharArray(), licensePlateCharCount);
            if(bestMatch == 0) continue;
            if(bestMatch == maxMatch && word.length() < shortestLen) {
                response = word;
                shortestLen = word.length();
            } else if(bestMatch > maxMatch) {
                maxMatch = bestMatch;
                response = word;
                shortestLen = word.length();
            }
        }

        return response;
    }

    private static int bestMatch(char[] wordChar, int[] licensePlateCharCount) {
        var wordCount = new int[256];
        for(var c: wordChar) {
            wordCount[c]++;
        }

        int matchCount = 0;
        for(int c=0; c<256;c++) {
            if(wordCount[c] != 0 && licensePlateCharCount[c] != 0) {
                if (wordCount[c] == licensePlateCharCount[c]) {
                    matchCount += wordCount[c];
                } else {
                    matchCount += Math.min(wordCount[c], licensePlateCharCount[c]);
                }
            }
        }

        return matchCount;
    }

}
