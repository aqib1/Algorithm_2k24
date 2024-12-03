package org.algorithms.io.meta;

import java.util.*;

public class TopKFrequent {
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
