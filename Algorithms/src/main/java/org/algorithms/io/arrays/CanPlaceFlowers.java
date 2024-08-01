package org.algorithms.io.arrays;

public class CanPlaceFlowers {
    public static void main(String[] args) {
        var canPlaceFlowers = new CanPlaceFlowers();

        System.out.println(
                canPlaceFlowers.canPlaceFlowersBruteForce(
                        // 2
                        new int[]{1,0,0,0,1},
                        2
                )
        );
    }

    // [1,0,0,0,1]
    // O(N)
    public boolean canPlaceFlowersBruteForce(int[] flowerbed, int n) {
        int maxFlowersCanPlace = 0;

        if (flowerbed.length == 1
                && flowerbed[0] == 0) {
            maxFlowersCanPlace++;
        } else {
            for (int i = 0; i < flowerbed.length; i++) {
                if(i == 0) {
                    if(flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                        maxFlowersCanPlace++;
                        flowerbed[i] = 1;
                    }
                } else if(i == flowerbed.length - 1) {
                    if(flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
                        maxFlowersCanPlace++;
                        flowerbed[i-1] = 1;
                    }
                } else {
                    if(flowerbed[i] == 0 && flowerbed[i-1] == 0 && flowerbed[i+1] == 0) {
                        flowerbed[i] = 1;
                        maxFlowersCanPlace++;
                    }
                }
            }
        }


        return n <= maxFlowersCanPlace;
    }
}
