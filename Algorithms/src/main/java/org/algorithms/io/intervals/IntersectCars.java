package org.algorithms.io.intervals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class IntersectCars {

    public static void main(String[] args) {
        var i = new IntersectCars();
        System.out.println(
                i.numberOfPoints(
                        new ArrayList<>(List.of(
                                new ArrayList<>(List.of(
                                         3, 8
                                )),
                                new ArrayList<>(List.of(
                                        4, 4
                                )),
                                new ArrayList<>(List.of(
                                        9, 10
                                )),
                                new ArrayList<>(List.of(
                                        9, 10
                                ))
                        ))
                )
        );
    }

    // Time complexity O(N * K)
    // Space O(NK) = O(N)
    public int numberOfPoints(List<List<Integer>> nums) {
        var set = new HashSet<Integer>();
        for(var num: nums) {
            for(int i = num.getFirst(); i <= num.getLast(); i++) {
                set.add(i);
            }
        }
        return set.size();
    }
}
