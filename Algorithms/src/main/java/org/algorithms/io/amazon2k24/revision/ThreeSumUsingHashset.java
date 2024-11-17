package org.algorithms.io.amazon2k24.revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSumUsingHashset {
    public static void main(String[] args) {
        System.out.println(
                threeSum(new int[] {-2,0,1,1,2})
        );
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> response = new ArrayList<>();
        for(int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if(i == 0 || nums[i - 1] != nums[i]) {
                findTriplets(i, nums, response);
            }
        }
        return response;
    }

    public static void findTriplets(
            int i,
            int[] nums,
            List<List<Integer>> response
    ) {
        var set = new HashSet<Integer>();
        for(int j = i + 1; j < nums.length; j++) {
            int complement = -nums[i] - nums[j];
            if(set.contains(complement)) {
                response.add(List.of(
                        nums[i],
                        nums[j],
                        complement
                ));

                while(j + 1 < nums.length && nums[j] == nums[j + 1]) j++;
            }
            set.add(nums[j]);
        }
    }
}
