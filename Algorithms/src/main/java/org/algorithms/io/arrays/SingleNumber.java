package org.algorithms.io.arrays;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(
                singleNumber(new int[] {
                        4,1,2,1,2
                })
        );
    }
    public static int singleNumber(int[] nums) {
        var map = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(
          s -> s, LinkedHashMap::new, Collectors.counting()));
        return Math.toIntExact(map.entrySet().stream()
                .filter(entry -> entry.getValue() == 1L)
                .map(Map.Entry::getKey)
                .findFirst().orElse(1));
    }
}
