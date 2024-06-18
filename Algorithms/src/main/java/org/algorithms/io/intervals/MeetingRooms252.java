package org.algorithms.io.intervals;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms252 {
    public static void main(String[] args) {
        var meeting = new MeetingRooms252();
        System.out.println(
                meeting.canAttendMeetings(
                        new int[][] {
                                {7, 10},
                                {2, 4}
                        }
                )
        );
    }

    // Time complexity ON(logN)
    // Space O(1)
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length == 0)
            return true;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));


        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i - 1][1] > intervals[i][0]) return false;
        }

        return true;
    }
}
