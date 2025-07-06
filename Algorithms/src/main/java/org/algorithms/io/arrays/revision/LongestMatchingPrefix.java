package org.algorithms.io.arrays.revision;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class LongestMatchingPrefix {

    public static void main(String[] args) {
        System.out.println(
                longestMatchingWord(
                        "apple",
                        List.of("apricot", "application", "banana", "ape")
                )
        );
    }

    // Time OnLog(n) and space O(n)
    public static String longestMatchingWord(String word, List<String> dictionary) {
        var trie = new Trie();
        trie.insert(word);
        var maxHeap = new PriorityQueue<Map.Entry<Integer, String>>(
                (entry1, entry2) ->
                        entry2.getKey().compareTo(entry1.getKey())
        );

        for (var dic : dictionary) {
            var prefix = trie.prefixLen(dic);
            maxHeap.offer(new AbstractMap.SimpleEntry<>(prefix, dic));
        }
        return maxHeap.isEmpty() ? "No Record" : maxHeap.poll().getValue();
    }

    static class Trie {
        private static final int MAX = 26;
        private final Trie[] nodes;
        private int current;
        private int end;

        public Trie() {
            this.nodes = new Trie[MAX];
        }

        public void insert(String word) {
            var lowerCase = word.toLowerCase();
            var current = this;

            for (char ch : lowerCase.toCharArray()) {
                var key = ch - 'a';
                if (current.nodes[key] == null) {
                    current.nodes[key] = new Trie();
                }
                current = current.nodes[key];
                current.current++;
            }

            current.end++;
        }

        public int prefixLen(String prefix) {
            var lowerCase = prefix.toLowerCase();
            var current = this;

            for (char ch : lowerCase.toCharArray()) {
                var key = ch - 'a';
                if (current.nodes[key] == null) {
                    break;
                }
                current = current.nodes[key];
            }
            return current.current;
        }
    }
}
