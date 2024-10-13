package org.algorithms.io.arrays;

import java.util.*;

public class TimeTaken {

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(timeTaken(new int[]{
                        0, 0, 0, 1, 1, 6
                }, new int[]{
                        1, 1, 0, 0, 1, 0
                }))
        );
    }

    // Time complexity O(n)
    // Space complexity
    // Response - O(n)
    // Entering - O(m)
    // Existing - O(k)
    // Entering + Existing = m + k = n
    // so O(n) + O(n) = O(2n) = O(n)
    public static int[] timeTaken(int[] arrival, int[] state) {
        var maxLimit = arrival.length;
        var response = new int[maxLimit];
        var entering = new ArrayList<Integer>(maxLimit); // 0 - state
        var existing = new ArrayList<Integer>(maxLimit); // 1 - state

        for (int i = 0; i < state.length; i++) {
            if (state[i] == 0) {
                entering.add(i);
            } else {
                existing.add(i);
            }
        }

        var time = 0;
        var ent_ptr = 0;
        var ext_ptr = 0;
        var last_state = -1; // to cover use case when door not used at all

        while (ent_ptr < entering.size() || ext_ptr < existing.size()) {
            // 1- check both users need to enter or exist
            if (ent_ptr < entering.size() && arrival[entering.get(ent_ptr)] <= time
                    && ext_ptr < existing.size() && arrival[existing.get(ext_ptr)] <= time) {
                if (last_state == 0) {
                    // need to enter as last status was entered
                    response[entering.get(ent_ptr++)] = time;
                } else {
                    // either -1 or 1 in both cases we need to exit
                    response[existing.get(ext_ptr++)] = time;
                    last_state = 1; // it is used now
                }
            } else if (ent_ptr < entering.size() && arrival[entering.get(ent_ptr)] <= time) {
                response[entering.get(ent_ptr++)] = time;
                last_state = 0;
            } else if (ext_ptr < existing.size() && arrival[existing.get(ext_ptr)] <= time) {
                response[existing.get(ext_ptr++)] = time;
                last_state = 1;
            } else {
                // time skip
                if (ent_ptr < entering.size() && ext_ptr < existing.size()) {
                    time = Math.min(
                            arrival[entering.get(ent_ptr)],
                            arrival[existing.get(ext_ptr)]
                    ) - 1; // minus one because we are incrementing later
                }
                last_state = -1;
            }

            time++;
        }
        return response;
    }
}
