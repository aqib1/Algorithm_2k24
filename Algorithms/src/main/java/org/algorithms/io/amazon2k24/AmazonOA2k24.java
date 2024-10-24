package org.algorithms.io.amazon2k24;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AmazonOA2k24 {
    public static void main(String[] args) {
        System.out.println(suitableLocations(
                new ArrayList<>(List.of(-253230108)),
                1837848
        ));
    }

    public static int getLongestSubstring(String s) {
        if(s.length() < 2) return 0;
        int maxLength = 0;
        int start = 0, end = 1;
        while(start < s.length() && end < s.length()) {
            if(s.charAt(start) > s.charAt(end)) {
                end++;
            } else {
                maxLength = Math.max(maxLength, end - start + 1);
            }
        }

        return maxLength;

    }

    public static int suitableLocations(List<Integer> center, long d) {
        int suitableLocations = 0;

        Collections.sort(center);
        var smallest = -1 * Math.pow(10, 9);
        var largest = Math.pow(10, 9);
        for(var location = smallest; location <= largest; location++) {
           var distance = calculateDistance(location, center);
           if(distance <= d) {
               suitableLocations++;
           }
        }

        return suitableLocations;
    }

    private static double calculateDistance(double location, List<Integer> center) {
        double distance = 0;
        for(int c: center) {
            distance += 2 * Math.abs(location - c);
        }
        return distance;
    }
}
