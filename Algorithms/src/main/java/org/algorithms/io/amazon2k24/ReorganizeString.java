package org.algorithms.io.amazon2k24;

import java.util.*;

public class ReorganizeString {
    public static void main(String[] args) {
        System.out.println(reorganizeString("vvvlo"));
    }

    // time O(n) and space O(1)
    public static String reorganizeString(String s) {
        StringBuilder construct = new StringBuilder();
        var charCount = new HashMap<Character, Integer>();
        var maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>(
                (a, b) -> Integer.compare(b.getValue(), a.getValue())
        );

        for(char c: s.toCharArray()) charCount.put(c, charCount.getOrDefault(c, 0) + 1);

        for(char c: charCount.keySet()) maxHeap.offer(new AbstractMap.SimpleEntry<>(c, charCount.get(c)));

        while(maxHeap.size() > 1) {
            var first = maxHeap.poll();
            var second = maxHeap.poll();
            construct.append(String.valueOf(first.getKey()) + second.getKey());
            if(first.getValue() - 1 > 0) {
                maxHeap.offer(new AbstractMap.SimpleEntry<>(first.getKey(), first.getValue() - 1));
            }
            if(second.getValue() - 1 > 0) {
                maxHeap.offer(new AbstractMap.SimpleEntry<>(second.getKey(), second.getValue() - 1));
            }
        }

        while(!maxHeap.isEmpty()) {
            var curr = maxHeap.poll();
            if(curr.getValue() > 1) return "";
            construct.append(curr.getKey());
        }

        return construct.toString();
    }
}
