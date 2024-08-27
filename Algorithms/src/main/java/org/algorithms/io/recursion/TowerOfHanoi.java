package org.algorithms.io.recursion;

public class TowerOfHanoi {
    // Driver code
    public static void main(String[] args) {
        int N = 3;

        // A, B and C are names of rods
        towerOfHanoi(N, 'A', 'C', 'B');
    }

    /*
     * Move disk 1 from A to C
     * Move disk 2 from A to B
     * Move disk 1 from C to B
     * Move disk 3 from A to C
     * Move disk 1 from B to A
     * Move disk 2 from B to C
     * Move disk 1 from A to C
     */
    public static void towerOfHanoi(int n, char from, char to, char via) {
        if(n == 0)
            return;
        towerOfHanoi(n - 1, from, via, to); // from -> to
        System.out.println("Move disk "+ n +" from rod "+ from + " to rod " + to);
        towerOfHanoi(n - 1, via, to, from); // via -> from
    }
}
