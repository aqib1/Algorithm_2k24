package org.algorithms.io.amazon2k24;


import java.util.*;

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

//[-1,0,1,2,-1,-4]
// [-4,-1,-1,0,1,2]
public class ThreeSumWithHashSet {
    //
    public static void main(String[] args) {
        System.out.println(
                threeSum(new int [] {-1,0,1,2,-1,-4})
        );
    }

   // Time complexity O(n2) and space is O(n)
    public static List<List<Integer>> threeSum(int[] nums) {
       Arrays.sort(nums);
       List<List<Integer>> response = new ArrayList<>();
       for(int i = 0; i < nums.length && nums[i] <= 0; i++) {
           if(i == 0 || nums[i - 1] != nums[i]) {
               twoSum(i, nums, response);
           }
       }

       return response;
    }

    private static void twoSum(int i, int[] nums, List<List<Integer>> response) {
        var complementSet = new HashSet<Integer>();
        for(int j = i + 1; j < nums.length; j++) {
            int complement = -nums[i] - nums[j];

            if(complementSet.contains(complement)) {
                response.add(new ArrayList<>(
                        List.of(
                                nums[i],
                                nums[j],
                                complement
                        )
                ));

                while(j + 1 < nums.length && nums[j] == nums[j + 1]) j++;
            }
            complementSet.add(nums[j]);
        }
    }
}
