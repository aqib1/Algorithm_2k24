package org.algorithms.io.arrays;


public class BestTimeToBuyAndSaleStock {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int [] {7, 1, 5, 3, 6, 4}));
    }
    // [7, 6, 6, 6, 6, 4]
    public static int maxProfit(int[] prices) {
        int limit = prices.length;
        int []maxRight = new int[limit];
        int max = prices[limit - 1];
        maxRight[limit - 1]  = max;
        for(int i = limit - 2; i >= 0; i--) {
            if(prices[i] >= max) {
                max = prices[i];
            }
            maxRight[i] = max;
        }

        int maxProfit = 0;
        for(int i = 0; i < prices.length - 1; i++) {
            if(prices[i] < maxRight[i + 1]) {
                maxProfit = Math.max(maxProfit, maxRight[i + 1] - prices[i]);
            }
        }

        return maxProfit;
    }
}
