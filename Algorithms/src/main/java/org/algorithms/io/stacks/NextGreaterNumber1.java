package org.algorithms.io.stacks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterNumber1 {

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        nextGreaterElement(
                                new int [] {4,1,2},
                                new int [] {1,3,4,2}
                        )
                )
        );
    }

    // Time complexity O(n)
    // Space complexity O(n)
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        var nextGreaterNumber = new HashMap<Integer, Integer>();
        var monotonicStack = new Stack<Integer>();

        for(int i = nums2.length - 1; i >=0; i--) {
            int num = nums2[i];
            while(!monotonicStack.isEmpty() && num >= monotonicStack.peek()) {
                monotonicStack.pop();
            }

            if(monotonicStack.isEmpty()) {
                nextGreaterNumber.put(num, -1);
            } else {
                nextGreaterNumber.put(num, monotonicStack.peek());
            }

            monotonicStack.push(num);
        }

        for(int i = 0; i < nums1.length; i++) {
            nums1[i] = nextGreaterNumber.get(nums1[i]);
        }

        return nums1;
    }
}
