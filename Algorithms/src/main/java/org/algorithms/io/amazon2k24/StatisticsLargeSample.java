package org.algorithms.io.amazon2k24;

import java.util.ArrayList;
import java.util.Arrays;

public class StatisticsLargeSample {
    public static void main(String[] args) {
        var st = new StatisticsLargeSample();
        System.out.println(Arrays.toString(
                // 0, 1, 2, 3, 4
                st.sampleStats(new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3510,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,6718,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,27870,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,35,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,26256,0,0,0,0,9586565,0,0,0,0,0,0,0,2333,0,0,0,0})
        ));
    }
    public double[] sampleStats(int[] count) {
        double []response = new double[5];
        int minValue = Integer.MAX_VALUE, maxValue = Integer.MIN_VALUE;
        int mode = 0, maxOcr = Integer.MIN_VALUE;
        long sumNumbers = 0;
        for(int i = 0; i < count.length; i++) {
            if(count[i] != 0) {
                sumNumbers += count[i];
                minValue = Math.min(minValue, i);
                maxValue = Math.max(maxValue, i);
                if(maxOcr < count[i]) {
                    maxOcr = count[i];
                    mode = i;
                }
            }
        }

        response[0] = minValue;
        response[1] = maxValue;

        response[2] = findMean(count);
        response[3] = findMedian(sumNumbers, count);
        response[4] = mode;

        return response;
    }

    private double findMedian(long sumNumbers, int[] count) {
        int sum = 0, current = 0, previous = 0;
        for(int i = 0; i < count.length; i++) {
            if(count[i] != 0) {
                sum += count[i];

                if (sum >= sumNumbers / 2 + 1) {
                    current = i;
                    break;
                }

                previous = i;
            }
        }

        if(sumNumbers % 2 == 1)
            return current;
        if(sum - count[current] >= sumNumbers / 2) {
            return (current + previous) / 2.0;
        }

        return current;
    }

    private double findMean(int[] count) {
        double sum = 0.0;
        double size = 0.0;
        for(int i = 0; i < count.length; i++) {
            if(count[i] != 0) {
                sum += (i * (long)count[i]);
                size += count[i];
            }
        }
        return sum / size;
    }
}
