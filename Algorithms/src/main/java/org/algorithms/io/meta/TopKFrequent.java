package org.algorithms.io.meta;

import java.util.*;

public class TopKFrequent {


    public int compareToKFrequentWords(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
        int countComp = e1.getValue().compareTo(e2.getValue());
        return countComp != 0 ? countComp : e2.getKey().compareTo(e1.getKey());
    }

    // Time complexity ONLog(N)
    // Space complexity O(n)
    public List<String> topKFrequentBetterSpace(String [] words, int k) {
        var topKResponse = new ArrayList<String>();
        var minHeap = new PriorityQueue<>(k, this::compareToKFrequentWords);
        var wordCount = new HashMap<String, Integer>();

        for(var word: words) wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);

        for(var entry: wordCount.entrySet()) {
            if(minHeap.size() < k) {
                minHeap.offer(entry);
            } else {
                if(compareToKFrequentWords(entry, minHeap.peek()) > 0) {
                    minHeap.poll();
                    minHeap.offer(entry);
                }
            }
        }

        while(k > 0) {
            topKResponse.add(minHeap.poll().getKey());
            k--;
        }

        Collections.reverse(topKResponse);

        return topKResponse;
    }

    // Time complexity ONLog(N)
    // Space complexity O(n)
    public List<String> topKFrequent(String[] words, int k) {
        var wordCount = new HashMap<String, Integer>();
        var maxHeap = new PriorityQueue<Map.Entry<String, Integer>>(
                k,
                (e1, e2) -> {
                    int comp = e2.getValue().compareTo(e1.getValue());
                    return comp != 0 ? comp : e1.getKey().compareTo(e2.getKey());
                }
        );

        var response = new ArrayList<String>();
        for (var word : words)
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);

        for (var key : wordCount.keySet()) {
            maxHeap.offer(new AbstractMap.SimpleEntry<>(key, wordCount.get(key)));
        }

        while (!maxHeap.isEmpty() && k > 0) {
            response.add(maxHeap.poll().getKey());
            k--;
        }

        return response;
    }
}
