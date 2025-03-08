package org.algorithms.io.divide_and_conquer;


import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;

public class ClosetPairPoints {
    public static void main(String[] args) {
        var closest = new ClosetPairPoints();
        Point[] P = new Point[]{
                new Point(2, 3),
                new Point(12, 30),
                new Point(40, 50),
                new Point(5, 1),
                new Point(12, 10),
                new Point(3, 4)

        };

        DecimalFormat df = new DecimalFormat("#.######");
        System.out.println("The smallest distance is " +
                df.format(closest.closest(P)));
    }
    public double closest(Point[] points) {
        Arrays.sort(points, new XPointComparator());
        return closeUntil(points, 0, points.length);
    }

    private double closeUntil(Point[] points, int start, int end) {
        if(end - start <= 3) {
            return bruteForce(points, end);
        }
        int mid = start + (end - start) / 2;
        Point midPoint = points[mid];
        double closeLeft = closeUntil(points, start, mid);
        double closeRight = closeUntil(points, mid, end);

        double min = Math.min(closeLeft, closeRight);

        return Math.min(min, findClosestOnStrip(points, midPoint, min, end));
    }

    private double findClosestOnStrip(Point[] points, Point midPoint, double min, int end) {
        Point[] stripePoints = new Point[end];
        int k = 0;
        for(int i = 0; i < end; i++) {
            if(Math.abs(points[i].x - midPoint.x) < min)
                stripePoints[k++] = points[i];
        }

        Arrays.sort(stripePoints, 0, k, new YPointComparator());

        for(int i = 0; i < k; i++) {
            for(int j = i + 1;
                j < k && (stripePoints[j].y - stripePoints[i].y) < min && Point.getDistance(stripePoints[j], stripePoints[i]) < min;
                j++) {
                min = Point.getDistance(stripePoints[j], stripePoints[i]);
            }
        }

        return min;
    }

    private double bruteForce(Point[] points, int end) {
        double min = Double.MAX_VALUE;
        for(int i = 0; i < end; i++) {
            for(int j = i + 1; j < end; j++) {
                min = Math.min(min, Point.getDistance(points[j], points[i]));
            }
        }
        return min;
    }
}

class XPointComparator implements Comparator<Point> {
    @Override
    public int compare(Point o1, Point o2) {
        return Integer.compare(o1.x, o2.x);
    }
}

class YPointComparator implements Comparator<Point> {
    @Override
    public int compare(Point o1, Point o2) {
        return Integer.compare(o1.y, o2.y);
    }
}

class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static double getDistance(
            Point p1,
            Point p2
    ) {
        return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
    }
}
