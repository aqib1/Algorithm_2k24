package org.algorithms.io.queues;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senator {

    public static void main(String[] args) {
        System.out.println(
                predictPartyVictory("DDRRR")
        );
    }

    /*
    * DDRRR - the first D moves to the back and takes out the first R
      DRRD - the first D moves to the back and takes out the first R
      RDD - the first R moves to the back and takes out the first D
      DR - the first (and only) D moves to the back and takes out the first (and only) R
      D - D wins the vote.
    * */
    public static String predictPartyVictory(String senates) {
        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> dQueue = new LinkedList<>();

        int currentRightToVote = 0;
        for(char senate: senates.toCharArray()) {
            if(senate == 'R') {
                rQueue.add(currentRightToVote);
            } else {
                dQueue.add(currentRightToVote);
            }
            currentRightToVote++;
        }

        while(!rQueue.isEmpty() && !dQueue.isEmpty()) {
            int r = rQueue.poll();
            int d = dQueue.poll();

            if(r < d) {
                rQueue.add(currentRightToVote);
            } else {
                dQueue.add(currentRightToVote);
            }
            currentRightToVote++;
        }

        return rQueue.isEmpty() ? "Dire" : "Radiant";
    }
}
