package org.algorithms.io.divide_and_conquer;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;

import static org.algorithms.io.divide_and_conquer.Point.distance;

public class ClosestPairOfPoints {

    public static void main(String[] args) {
        var closest = new ClosestPairOfPoints();
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
                df.format(closest.close(P)));
    }

    public double close(Point[] points) {
        Arrays.sort(points, new PointXComparator());
        return closeUntil(points, 0, points.length);
    }

    private double closeUntil(Point[] points, int start, int end) {
        if (end - start <= 3) {
            return bruteForce(points, end);
        }

        int mid = start + (end - start) / 2;
        Point midPoint = points[mid];

        double distanceLeft = closeUntil(points, start, mid);
        double distanceRight = closeUntil(points, mid, end);
        double minDistance = Math.min(distanceLeft, distanceRight);

        return Math.min(minDistance, minDistanceInStrip(points, midPoint, minDistance, end));
    }

    private double minDistanceInStrip(Point[] points, Point midPoint, double minDistance, int end) {
        var stripPoints = new Point[end];
        int k = 0;
        for (int i = 0; i < end; i++) {
            if (Math.abs(points[i].x - midPoint.x) < minDistance) {
                stripPoints[k++] = points[i];
            }
        }

        Arrays.sort(stripPoints, 0, k, new PointYComparator());

        for(int i = 0; i < k; i++) {
            for(int j = i + 1;
                j < k && (stripPoints[j].y - stripPoints[i].y) < minDistance && distance(stripPoints[i], stripPoints[j]) < minDistance;
                j++
            ) {
                minDistance = distance(stripPoints[i], stripPoints[j]);
            }
        }

        return minDistance;
    }

    private double bruteForce(Point[] points, int end) {
        double min = Double.MAX_VALUE;
        for(int i = 0; i < end; i++) {
            for (int j = i + 1; j < end; j++) {
                min = Math.min(min, distance(points[i], points[j]));
            }
        }

        return min;
    }
}

class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static double distance(Point p1, Point p2) {
        return Math.sqrt(
                Math.pow(p1.x - p2.x, 2) +
                        Math.pow(p1.y - p2.y, 2)
        );
    }

}

class PointXComparator implements Comparator<Point> {

    @Override
    public int compare(Point o1, Point o2) {
        return Integer.compare(o1.x, o2.x);
    }
}

class PointYComparator implements Comparator<Point> {

    @Override
    public int compare(Point o1, Point o2) {
        return Integer.compare(o1.y, o2.y);
    }
}
