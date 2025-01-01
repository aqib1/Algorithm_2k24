package org.algorithms.io.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
}
