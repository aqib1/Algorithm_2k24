package org.algorithms.io.amazon2k24;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(
                groupAnagramsSlowApproach(new String[] {
                        "eat","tea","tan","ate","nat","bat"
                })
        );
    }

    // time complexity ON(logN) and space O(N)
    public static List<List<String>> groupAnagrams(String[] strs) {
        var groupAnagram = new HashMap<String, List<String>>();
        for(var str: strs) {
            var charData = str.toCharArray();
            Arrays.sort(charData);
            var key = new String(charData);
            if(groupAnagram.containsKey(key)) {
                groupAnagram.get(key).add(str);
            } else {
                groupAnagram.put(key, new ArrayList<>(List.of(str)));
            }
        }

        return new ArrayList<>(groupAnagram.values());
    }


    public static List<List<String>> groupAnagramsSlowApproach(String[] strs) {
        List<List<String>> response = new ArrayList<>();
        Queue<String> queue = new LinkedList<>(Arrays.asList(strs));

        while(!queue.isEmpty()) {
            var anagramGroup = new ArrayList<String>();
            var current = queue.poll();
            anagramGroup.add(current);
            int size = queue.size();
            for(int i = 0; i < size && !queue.isEmpty(); i++) {
                var second = queue.poll();
                if(isAnagram(current, second)) {
                    anagramGroup.add(second);
                } else {
                    queue.add(second);
                }
            }
            response.add(anagramGroup);
        }

        return response;
    }

    private static boolean isAnagram(String current, String second) {
        if(current.length() != second.length())
            return false;

        var charCount = new HashMap<Character, Integer>();
        for(int i = 0; i < current.length(); i++) {
            charCount.put(current.charAt(i), charCount.getOrDefault(current.charAt(i), 0) + 1);
            charCount.put(second.charAt(i), charCount.getOrDefault(second.charAt(i), 0) - 1);
        }

        for(var key: charCount.keySet()) {
            if(charCount.get(key) != 0) return false;
        }

        return true;
    }
}
