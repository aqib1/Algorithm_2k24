package org.algorithms.io.amazon2k24.revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumTwoPointer  {

    public static List<List<Integer>> threeSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> response = new ArrayList<>();
        for(int i = 0; i < nums.length && nums[i] <= target; i++) {
            if(i == 0 || nums[i - 1] != nums[i]) {
                findTriplets(i, nums, target, response);
            }
        }
        return response;
    }

    private static void findTriplets(int i, int[] nums, int target, List<List<Integer>> response) {
        int start = i + 1;
        int end = nums.length - 1;

        while(start < end) {
            int sum = nums[i] + nums[start] + nums[end];

            if(sum < target) {
                start++;
            } else if(sum > target) {
                end--;
            } else {
                    response.add(List.of(
                            nums[i],
                            nums[start++],
                            nums[end--]
                    ));

                  while(start < end && nums[start - 1] == nums[start]) start++;
            }
        }
    }
}
