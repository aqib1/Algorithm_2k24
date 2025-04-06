package org.algorithms.io.amazon2k25.sort.insertion;

import java.util.Arrays;

public class InsertionSortRecur {

    public static void main(String[] args) {
        var i = new InsertionSortRecur();
        var data = new int[]{4, -1, 0, 22, 76, 3, 12, -1};
        i.sort(data);
        System.out.println(Arrays.toString(data));
    }

    // Time complexity O(n2) and space O(n2)
    public void sort(int[] data) {
        sort(data, 1, data.length);
    }

    public void sort(int[] data, int i, int limit) {
        if (i >= limit)
            return;
        int keyData = data[i];
        shiftSort(i, keyData, data);
        sort(data, i + 1, limit);
    }

    private void shiftSort(int i, int keyData, int[] data) {
        if (i > 0 && data[i - 1] >= keyData) {
            data[i] = data[i - 1];
            shiftSort(i - 1, keyData, data);
        } else {
            data[i] = keyData;
        }
    }
}
