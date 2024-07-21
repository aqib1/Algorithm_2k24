package org.algorithms.io.meta;

public class HappyNumber {
    public static void main(String[] args) {
        var isHappy = new HappyNumber();
        System.out.println(isHappy.isHappy(19));
    }

    // Time complexity OLog(n)
    // Space complexity O(1)
    public boolean isHappy(int n) {
        while(n > 9) {
            n = getSqOfEachNumber(n);
        }

        return n == 1 || n == 7;
    }

    private int getSqOfEachNumber(int n) {
          int res = 0;
          while(n != 0) {
              res += (int)Math.pow(n%10, 2);
              n /= 10;
          }
          return res;
    }
}
