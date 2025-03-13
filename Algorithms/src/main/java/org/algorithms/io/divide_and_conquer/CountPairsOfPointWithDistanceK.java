package org.algorithms.io.divide_and_conquer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CountPairsOfPointWithDistanceK {
//    public static class XPointComparator implements Comparator<Point> {
//
//        @Override
//        public int compare(Point o1, Point o2) {
//            return Integer.compare(o1.x, o2.x);
//        }
//    }
//
//    public static class YPointComparator implements Comparator<Point> {
//
//        @Override
//        public int compare(Point o1, Point o2) {
//            return Integer.compare(o1.y, o2.y);
//        }
//    }
//
//    public static class Point {
//        public int x;
//        public int y;
//
//        public Point(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//
//        public static int distance(Point p1, Point p2) {
//            return (p1.x ^ p2.x) + (p1.y ^ p2.y);
//        }
//    }
//
//    public int countPairs(List<List<Integer>> coordinates, int k) {
//        var points = new Point[coordinates.size()];
//        int j = 0;
//        for(var coordinate: coordinates) {
//            points[j] = new Point(coordinate.getFirst(), coordinate.getLast());
//            j++;
//        }
//        Arrays.sort(points, new XPointComparator());
//        return countUntil(points, 0, points.length, k);
//    }
//
//    private int countUntil(Point[] points, int start, int end, int k) {
//        if(end - start <= 3) {
//            return bruteForce(points, end, k);
//        }
//        int mid = start + (end - start) / 2;
//        var midPoint = points[mid];
//        int dLeft = countUntil(points, start, mid, k);
//        int dRight = countUntil(points, mid, end, k);
//        int distance;
//        if(dLeft == k) {
//            distance = dLeft;
//        } else if(dRight == k) {
//            distance = dRight;
//        } else if(k > dLeft) {
//
//        }
//    }
//
//    private int bruteForce(Point[] points, int end, int k) {
//    }
}