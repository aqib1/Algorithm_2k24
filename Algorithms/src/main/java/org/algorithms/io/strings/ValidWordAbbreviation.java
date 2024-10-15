package org.algorithms.io.strings;

public class ValidWordAbbreviation {
    public static void main(String[] args) {
        System.out.println(validWordAbbreviation("apple", "a2e" ));
    }

    public static boolean validWordAbbreviation(String word, String abbr) {
        var abbrData = abbr.toCharArray();
        var wordData = word.toCharArray();
        int abbrPtr = 0;
        int wordPtr = 0;
        while (abbrPtr < abbrData.length && wordPtr < wordData.length) {
            if (wordData[wordPtr] == abbrData[abbrPtr]) {
                wordPtr++;
                abbrPtr++;
                continue;
            }
            if (abbrData[abbrPtr] < '0' || abbrData[abbrPtr] > '9') {
                return false;
            }
            if (abbrData[abbrPtr] == '0') return false;

            int number = 0;
            while (abbrPtr < abbrData.length && abbrData[abbrPtr] >= '0' && abbrData[abbrPtr] <= '9') {
                number = number * 10 + abbrData[abbrPtr] - '0';
                abbrPtr++;
            }

            if (wordData.length < wordPtr + number) {
                return false;
            }

            wordPtr += number;
        }

        return wordPtr == wordData.length && abbrPtr == abbrData.length;
    }
}
