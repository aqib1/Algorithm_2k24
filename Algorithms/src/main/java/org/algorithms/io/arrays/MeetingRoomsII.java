package org.algorithms.io.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public static void main(String[] args) {
        var meeting = new MeetingRoomsII();
        System.out.println(meeting.minMeetingRooms(
                new int[][]{{1,9},{3,15},{6,16},{9,16}}
        ));
    }

    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0)
            return 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // {1,9},{3,15},{6,16},{9,16}
        var minHeap = new PriorityQueue<Integer>();
        for (int[] interval : intervals) {
            if (minHeap.isEmpty()) {
                minHeap.offer(interval[1]);
            } else {
                if (interval[0] < minHeap.peek()) {
                    minHeap.offer(interval[1]);
                } else if (interval[0] >= minHeap.peek()) {
                    minHeap.poll();
                    minHeap.offer(interval[1]);
                }
            }
        }

        return minHeap.size();
    }
}
