package org.algorithms.io.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DifferenceBwTwoArrays {

  // Timer O(n) Space O(n)
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        var nums1Set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        var num2Set = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        List<List<Integer>> result = new ArrayList<>(List.of(
                nums1Set.stream().filter(i -> !num2Set.contains(i))
                        .toList()
        ));

        result.add(
                num2Set.stream().filter(i -> !nums1Set.contains(i))
                        .toList()
        );

        return result;
    }
}
