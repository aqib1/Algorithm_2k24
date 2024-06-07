package com.algorithms.io;


public class ArrayStringsAreEqual {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        var word1String = String.join("", word1);
        var word2String = String.join("", word2);

        return word1String.equals(word2String);
    }
}
