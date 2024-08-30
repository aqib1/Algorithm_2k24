package org.algorithms.io.stacks;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        asteroidCollision(new int[]{5, 10, -5})
                )
        );
    }

    // time complexity O(N) and space O(N)
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int asteroid : asteroids) {
            var isAlive = true;

            while(!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                if(stack.peek() < -asteroid) {
                    stack.pop();
                    continue;
                } else if(stack.peek() == -asteroid) {
                    stack.pop();
                }

                isAlive = false;
                break;
            }

            if(isAlive)
                stack.push(asteroid);
        }

        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}
