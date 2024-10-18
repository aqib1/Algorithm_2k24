package org.algorithms.io.arrays;

public class FindKthPositive {
    public int findKthPositive(int[] arr, int k) {
        int i = 1;
        int arrCount = 0;
        int missingPerson = -1;
        while(k != 0) {
            if(arrCount < arr.length && arr[arrCount] == i) {
                arrCount++;
            } else {
                missingPerson = i;
                k--;
            }

            i++;
        }
        return missingPerson;
    }
}
