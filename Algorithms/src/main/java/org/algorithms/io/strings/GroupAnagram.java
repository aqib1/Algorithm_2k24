package org.algorithms.io.strings;

import java.util.*;

public class GroupAnagram {

    // Time complexity OnLog(n)
    // Space complexity O(n)
    public List<List<String>> groupAnagrams(String[] strs) {
        var groupAnagram = new HashMap<String, List<String>>();

        for(var str: strs) {
            var charStr = str.toCharArray();
            Arrays.sort(charStr);
            var key = new String(charStr);
            if(groupAnagram.containsKey(key)) {
                groupAnagram.get(key).add(str);
            } else {
                groupAnagram.put(key, new ArrayList<>(List.of(str)));
            }
        }

        return new ArrayList<>(groupAnagram.values());
    }


    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // code here
        Map<String, ArrayList<String>> groupAnagram = new HashMap<String, ArrayList<String>>();
        ArrayList<ArrayList<String>> response = new ArrayList<ArrayList<String>>();

        for(var str: arr) {
            var charStr = str.toCharArray();
            Arrays.sort(charStr);
            var key = new String(charStr);
            if(groupAnagram.containsKey(key)) {
                groupAnagram.get(key).add(str);
            } else {
                groupAnagram.put(key, new ArrayList<>(List.of(str)));
            }
        }

        for(String key: groupAnagram.keySet()) {
            response.add(groupAnagram.get(key));
        }

        return response;
    }
}
