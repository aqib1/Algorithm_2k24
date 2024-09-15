package org.algorithms.io.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ClosetColor {
    private static final Map<String, int[]> RGB_MAP = Map.of(
            "Black", new int[]{0, 0, 0},
            "White", new int[]{255, 255, 255},
            "Red", new int[]{255, 0, 0},
            "Green", new int[]{0, 255, 0},
            "Blue", new int[]{0, 0, 255}
    );

    public static void main(String[] args) {
        var closetColor = new ClosetColor();
        System.out.println(
                closetColor.colorDistance(
                        new String[]{
                                "101111010110011011100100",
                                "110000010101011111101111",
                                "100110101100111111101101",
                                "010111011010010110000011",
                                "000000001111111111111111"
                        }
                )
        );
    }

    // Time complexity O(n) where n are pixels
    // Space O(5) + response O(n) where n are min distance color from each pixel
    public List<String> colorDistance(String[] pixels) {
        if (pixels.length == 0)
            return List.of();
        var response = new ArrayList<String>();
        for (var pixel : pixels) {
            var pixelSplit = new int[3];
            int j = 0;
            for (int i = 0; i < pixel.length(); i += 8) {
                pixelSplit[j] = parseIntegerToBase2(
                        pixel.substring(i, i + 8)
                );
                j++;
            }

            double min = Long.MAX_VALUE;
            String found = null;
            int countClosest = 1;
            for (var key : RGB_MAP.keySet()) {
                var rgbValue = RGB_MAP.get(key);
                double squareSum = 0.0;
                for (int v = 0; v < rgbValue.length; v++) {
                    squareSum += Math.pow(
                            pixelSplit[v] - rgbValue[v], 2
                    );
                }
                var sqrt = Math.sqrt(squareSum);
                if (sqrt < min) {
                    min = sqrt;
                    found = key;
                } else if(sqrt == min) {
                    countClosest++;
                }
            }
            if (found != null && countClosest == 1)
                response.add(found);
            else response.add("Ambiguous");
        }

        return response;
    }

    private int parseIntegerToBase2(String number) {
        return Integer.parseInt(number, 2);
    }
}
