package org.algorithms.io.google;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicatesFromArray {
    // Time O(n) and Space O(k)
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> response = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            if(nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
            } else response.add(Math.abs(nums[i]));
        }


        return response;
    }
}
