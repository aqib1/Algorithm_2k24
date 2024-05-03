package org.algorithms.io.top150;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        var r = new RemoveElement();
        var nums = new int[] {0,1,2,2,3,0,4,2};
        System.out.println(r.removeElement(nums, 2));
        System.out.println(Arrays.toString(nums));
    }

    // Time complexity O(n) and space O(1)
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0)
            return 0;
        int slow = 0;
        int fast = 0;

        while(fast < nums.length) {
            if(nums[fast] == val) {
                fast++;
            } else {
                nums[slow++] = nums[fast++];
            }
        }

        return slow;
    }
}
