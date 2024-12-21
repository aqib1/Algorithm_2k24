package org.algorithms.io.number;

public class PeasantMultiply {
    public static void main(String[] args) {
        System.out.println(peasantMultiply(2, 7));
    }
    // time OLog(min(x, y))
    // space complexity O(1)
    public static int peasantMultiply(int x, int y) {
        if(y < x) {
            int tmp = y;
            y = x;
            x = tmp;
        }

        int product = 0;
        while(x > 0) {
            if(x % 2 == 1)
                product += y;

            x = Math.floorDiv(x, 2);
            y += y;
        }
        return product;
    }
}
