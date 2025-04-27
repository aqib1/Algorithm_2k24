package org.algorithms.io.interviewPrep2k25.arrays;

public class ContiguousSubArrayProductLessThanK {
    public static void main(String[] args) {
        var s = new ContiguousSubArrayProductLessThanK();
        System.out.println(
                s.solution(new int[] {10,5,2}, 101)
        );
    }

    // Time O(n) and space O(1)
    public int solution(int[] nums, int k) {
        if(k <= 1) return 0;

        int countSubArray = 0;
        int product = 1;
        for(int start = 0, end = 0; end < nums.length; end++) {
            product *= nums[end];

            while(product >= k)
                product /= nums[start++];

            countSubArray += (end - start) + 1;
        }

        return countSubArray;
    }
}
