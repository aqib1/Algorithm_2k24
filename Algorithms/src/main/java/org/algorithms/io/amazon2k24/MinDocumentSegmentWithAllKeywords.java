package org.algorithms.io.amazon2k24;

import java.util.HashMap;
import java.util.Set;

public class MinDocumentSegmentWithAllKeywords {
    public static void main(String[] args) {
        System.out.println(minSegmentWithAllKeywords(
                "I have itchy head I have very itchy head and neck I have a itchy head and feet",
                Set.of("have", "itchy", "head")
        ));
    }


    public static String minSegmentWithAllKeywords(
            String document,
            Set<String> keywords
    ) {
        int start = 0, end = 0;
        var response = "";
        int minLen = Integer.MAX_VALUE;
        var keyCount = new HashMap<String, Integer>();
        for(var key: keywords) keyCount.put(key, 0);

        var documentWords = document.split(" ");
        while(end < documentWords.length && start <= end) {
            if(!foundAll(keyCount) && keywords.contains(documentWords[end])) {
                keyCount.put(
                        documentWords[end],
                        keyCount.get(documentWords[end]) + 1
                );
            }

            if(foundAll(keyCount)) {
                var len = getShortestSegment(start, end, documentWords);
                if(minLen > len.length()) {
                    minLen = len.length();
                    response = len;
                }
                if(keyCount.containsKey(documentWords[start])) {
                    keyCount.put(
                            documentWords[start],
                            keyCount.get(documentWords[start]) - 1
                    );
                }
                start++;
                if((end - start) + 1 < keywords.size()) {
                    break;
                }
            }

            if(!foundAll(keyCount)) {
                end++;
            }
        }

        return response;
    }

    private static String getShortestSegment(int start, int end, String[] documentWords) {
        var builder = new StringBuilder();
        for(int i = start; i < end; i++) {
            builder.append(documentWords[i]).append(" ");
        }

        builder.append(documentWords[end]);

        return builder.toString();
    }

    private static boolean foundAll(HashMap<String, Integer> keyCount) {
        return keyCount.values().stream().noneMatch(v -> v == 0);
    }
}
