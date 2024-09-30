package org.algorithms.io.arrays.revision;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClosedColor {
    public static void main(String[] args) {
        var closetColor = new ClosedColor();
        System.out.println(
                closetColor.closeDistance(
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

    private static final Map<String, int[]> RGB_MAP = Map.of(
            "Black", new int[]{0, 0, 0},
            "White", new int[]{255, 255, 255},
            "Red", new int[]{255, 0, 0},
            "Green", new int[]{0, 255, 0},
            "Blue", new int[]{0, 0, 255}
    );

    public List<String> closeDistance(String[] pixels) {
        if (pixels.length == 0) return List.of();

        var response = new ArrayList<String>();
        for (var pixel : pixels) {
            var pixelSplit = new int[3];
            int j = 0;
            for (int i = 0; i < pixel.length(); i += 8) {
                pixelSplit[j] = parseIntToBase2(
                        pixel.substring(i, i + 8)
                );
                j++;
            }


            double min = Long.MAX_VALUE;
            String found = null;
            var closetCount = 1;

            for (var key : RGB_MAP.keySet()) {
                var rgbValue = RGB_MAP.get(key);
                var squareSum = 0.0;
                for (int i = 0; i < rgbValue.length; i++) {
                    squareSum += Math.pow(
                            pixelSplit[i] - rgbValue[i], 2
                    );
                }
                var sqrt = Math.sqrt(squareSum);

                if(sqrt < min) {
                    min = sqrt;
                    found = key;
                } else if(sqrt == min) {
                    closetCount++;
                }
            }

            if(found !=  null && closetCount == 1) {
                response.add(found);
            } else {
                response.add("Ambiguous");
            }
        }

        return response;
    }


    public int parseIntToBase2(String value) {
        return Integer.parseInt(value, 2);
    }
}
