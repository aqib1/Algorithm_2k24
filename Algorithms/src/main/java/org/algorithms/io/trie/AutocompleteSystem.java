package org.algorithms.io.trie;

import java.util.*;

public class AutocompleteSystem {
    static class Trie {
        private static final int LIMIT = 256;
        private final Trie[] nodes;
        private final Map<String, Integer> sentenceCount;
        private int end;
        private int count;

        public Trie() {
            this.nodes = new Trie[LIMIT];
            this.sentenceCount = new HashMap<>();
        }

        public void insert(String word, int count) {
            var current = this;
            for (char ch : word.toCharArray()) {
                if (current.nodes[ch] == null) {
                    current.nodes[ch] = new Trie();
                }
                current = current.nodes[ch];
                current.sentenceCount.put(word, current.sentenceCount.getOrDefault(word, 0) + count);
            }
            current.end++;
        }
    }

    private static int TOP = 3;
    private String prefix;
    private Queue<Map.Entry<String, Integer>> heap;
    private Trie trie;

    public AutocompleteSystem(String[] sentences, int[] times) {
        this.trie = new Trie();
        this.prefix = "";
        this.heap = new PriorityQueue<>(
                (e1, e2) ->
                        Objects.equals(e1.getValue(), e2.getValue()) ?
                                e1.getKey().compareTo(
                                        e2.getKey()
                                ) : Integer.compare(e2.getValue(), e1.getValue())
        );

        initData(sentences, times);
    }

    private void initData(String[] sentences, int[] times) {
        for(int i = 0; i < times.length; i++) {
            trie.insert(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        if (c == '#') {
            trie.insert(prefix, 1);
            prefix = "";
            return List.of();
        }

        heap.clear();
        prefix = prefix.concat(String.valueOf(c));
        var response = new ArrayList<String>();
        var current = trie;

        for(char ch: prefix.toCharArray()) {
            if(current.nodes[ch] == null)
                return List.of();
            current = current.nodes[ch];
        }

        for(var key : current.sentenceCount.keySet()) {
            heap.offer(new AbstractMap.SimpleEntry<>(
                    key,
                    current.sentenceCount.get(key)
            ));
        }

        for(int i = 0; i < TOP && !heap.isEmpty(); i++) {
            response.add(heap.poll().getKey());
        }

        return response;
    }

    public static void main(String[] args) {
        var complete = new AutocompleteSystem(
                new String[]{
                        "i love you",
                        "island",
                        "iroman",
                        "i love leetcode"
                },
                new int[]{5, 3, 2, 2}
        );

        System.out.println(complete.input('i'));
        System.out.println(complete.input(' '));
        System.out.println(complete.input('a'));
        System.out.println(complete.input('#'));
    }
}
