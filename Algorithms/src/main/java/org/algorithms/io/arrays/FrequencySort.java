package org.algorithms.io.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FrequencySort {
    public static void main(String[] args) {
        var frequency = new FrequencySort();
        System.out.println(
                Arrays.toString(
                        frequency.frequencySort(
                                new int[]{2,3,1,3,2}
                        )
                )
        );
    }

    // Space complexity O(n)
    // Time complexity O(n)
    public int[] frequencySort(int[] nums) {
        var valueByCount = new HashMap<Integer, Integer>();
        var result = new int[nums.length];
        Arrays.stream(nums).forEach(value -> {
            valueByCount.putIfAbsent(value, 0);
            valueByCount.put(value, valueByCount.get(value) + 1);
        });

        var data = valueByCount.entrySet().stream().sorted(
                (a, b) -> {
                    int compare =
                            Integer.compare(a.getValue(), b.getValue());
                    return compare == 0 ? Integer.compare(b.getKey(), a.getKey())
                            : compare;
                }
        ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        var atomicCounter = new AtomicInteger(0);
        data.forEach((key, value) -> IntStream.range(0, value)
                .forEach(i -> result[atomicCounter.getAndIncrement()] = key));
        return result;
    }
}
