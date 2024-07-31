package org.algorithms.io.arrays;

import java.util.ArrayList;
import java.util.List;

public class KidsWithGreatestNumberCandies {

    // Time complexity O(N) where N is the number of candies
    // Space complexity O(N)
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        var result = new ArrayList<Boolean>(candies.length);
        var max = Integer.MIN_VALUE;
        for (int candy : candies) {
            if (max < candy) max = candy;
        }

        for (int candy : candies) {
            if (candy + extraCandies >= max)
                result.add(true);
            else
                result.add(false);
        }

        return result;
    }
}
