package org.algorithms.io.arrays;

import java.util.*;

public class SuspiciousActivityLogs {

    public static void main(String[] args) {
        System.out.println(
                suspiciousUsers(
                        List.of(
                                "1 2 50",
                                "1 7 70",
                                "1 3 20",
                                "2 2 17"
                        ),
                        2
                )
        );
    }

    // Time complexity O(n) where n is number of logs
    // Space complexity O(k) where k is number of users. 
    public static List<String> suspiciousUsers(List<String> logs, int threshold) {
        if (Objects.isNull(logs) || logs.isEmpty())
            return List.of();
        var userIdByTransCount = new HashMap<String, Integer>();
        for (var log : logs) {
            var data = log.split(" ");
            if(data.length != 3) {
                throw new IllegalArgumentException();
            }
            int fillLimit = 2;
            if (data[0].equals(data[1])) {
                fillLimit = 1;
            }

            for (int i = 0; i < fillLimit; i++)
                userIdByTransCount.put(
                        data[i],
                        userIdByTransCount.getOrDefault(data[i], 0) + 1
                );
        }

        return userIdByTransCount
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() >= threshold)
                .map(Map.Entry::getKey)
                .toList();
    }
}
