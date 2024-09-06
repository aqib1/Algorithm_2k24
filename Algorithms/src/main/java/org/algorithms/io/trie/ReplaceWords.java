package org.algorithms.io.trie;

import java.util.*;

public class ReplaceWords {
    static class Trie {
        private static final int LIMIT = 26;
        private final Trie[] nodes;
        private int end;

        public Trie() {
            this.nodes = new Trie[LIMIT];
        }

        public void insert(String word) {
            var current = this;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (current.nodes[idx] == null) {
                    current.nodes[idx] = new Trie();
                }
                current = current.nodes[idx];
            }
            current.end++;
        }

        public String getWord(String word) {
            var builder = new StringBuilder();
            var current = this;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (current.nodes[idx] == null) {
                    return word;
                }
                current = current.nodes[idx];
                builder.append(ch);
                if(current.end > 0) return builder.toString();
            }

            return builder.toString();
        }

    }

    public String replaceWords(List<String> dictionary, String sentence) {
        var builder = new StringBuilder();
        var data = sentence.split(" ");
        var trie = new Trie();

        for (var dic : dictionary) {
            trie.insert(dic);
        }
        for(var d: data) {
            builder.append(trie.getWord(d)).append(" ");
        }
        return builder.substring(0, builder.length() - 1);
    }

    public static void main(String[] args) {
        var replace = new ReplaceWords();
        System.out.println(replace.replaceWords(
                        List.of("a", "aa", "aaa", "aaaa"),
                "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"
                )
        );
    }
}
