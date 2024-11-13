package org.algorithms.io.amazon2k24;

import java.util.*;

public class ThreeSumWithTwoPointer {
    /*
    * Input: nums = [-1,0,1,2,-1,-4]
    * Output: [[-1,-1,2],[-1,0,1]]

    * Explanation:
    * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
    * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
    * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
    * The distinct triplets are [-1,0,1] and [-1,-1,2].
    * Notice that the order of the output and the order of the triplets does not matter.
    *
    * */

    public static void main(String[] args) {
        System.out.println(threeSum(new int[] {0,0,0,0}));
    }

  // Time complexity On(logn) + O(n2*k) = O(n2)
  // Space is O(3n) = O(n) 

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return null;
        Arrays.sort(nums);
        List<List<Integer>> response = new ArrayList<>();
        for(int i = 0; i < nums.length && nums[i] <= 0; i++) {
                if(i == 0 || nums[i - 1] != nums[i])
                    findPair(i, nums, response);
        }

        return response;
    }

    private static void findPair(int i, int[] nums, List<List<Integer>> response) {
        int start = i + 1;
        int end = nums.length - 1;
        while(start < end) {
            var sum = nums[start] + nums[end] + nums[i];

            if(sum > 0) {
                end--;
            } else if(sum < 0) {
                start++;
            } else {
                response.add(new ArrayList<>(List.of(nums[start++], nums[end--], nums[i])));
                // skip duplicates
                while(start < end && nums[start - 1] == nums[start])
                        start++;
            }
        }
    }
}
