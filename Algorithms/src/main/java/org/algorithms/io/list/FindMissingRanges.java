package org.algorithms.io.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMissingRanges {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> response = new ArrayList<>();
        if (nums.length == 0) {
            response.add(Arrays.asList(lower, upper));
            return response;
        }

        if(lower < nums[0]) response.add(Arrays.asList(lower, nums[0] - 1));

        int last = nums[0];
        int i = 1;
        for(; i < nums.length; i++) {
            if(nums[i] - last != 1) {
                response.add(Arrays.asList(last + 1, nums[i] - 1));
            }
            last = nums[i];
        }

        if(upper > nums[i - 1]) response.add(Arrays.asList(nums[i - 1] + 1, upper));
        return response;
    }
}
