package org.algorithms.io.graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * There are n different online courses numbered from 1 to n. You are given an array courses where
 * courses[i] = [duration-i, lastDay-i] indicate that the ith course should be taken
 * continuously for duration days and must be finished before or on last Day-i.
 * You will start on the 1st day, and you cannot take two or more courses simultaneously.
 * Return the maximum number of courses that you can take.
 * Example 1:
 * Input: courses = [[100,200],[200,1300],[1000,1250],[2000,3200]]
 * Output: 3
 * Explanation:
 * There are totally 4 courses, but you can take 3 courses at most:
 * First, take the 1st course, it costs 100 days, so you will finish it on the 100th day, and ready to take
 * the next course on the 101st day.
 * Second, take the 3rd course, it costs 1000 days, so you will finish it on the 1100th day, and ready to take the
 * next course on the 1101-st day.
 * Third, take the 2nd course, it costs 200 days, so you will finish it on the 1300th day.
 * The 4th course cannot be taken now, since you will finish it on the 3300th day, which exceeds the closed date.
 * Example 2:
 * Input: courses = [[1,2]]
 * Output: 1
 * Example 3:
 * Input: courses = [[3,2],[4,3]]
 * Output: 0
 * Constraints:
 * 1 <= courses.length <= 104
 * 1 <= durationi, lastDayi <= 104
 * */

public class CourseSchedulingIII {
    public static void main(String[] args) {
        var schedule = new CourseSchedulingIII();
        System.out.println(
                schedule.scheduleCourse(
                        new int[][] {
                                {100, 200},
                                {200, 1300},
                                {1000, 1250},
                                {2000, 3200}
                        }
                )
        );
    }

    // Time complexity ON(LogN) and space O(N)
    public int scheduleCourse(int[][] courses) {
        // sort courses on the basis of last day in ascending, so we can pick course have
        // the lowest last day.
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        var maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        int timeElapsed = 0;
        for(var course: courses) {
            if(timeElapsed + course[0] <= course[1]) {
                timeElapsed += course[0];
                maxHeap.offer(course[0]);
            } else if(!maxHeap.isEmpty() && maxHeap.peek() > course[0]) {
                timeElapsed = (timeElapsed - maxHeap.poll()) + course[0];
                maxHeap.offer(course[0]);
            }
        }

        return maxHeap.size();
    }
}
