package com.example;

import java.util.*;

public class Main {
    // A flag for each set of particles
    // True if Patrick wins
    static boolean isPatrickWinner = false;

    public static void main(String[] args) {
        // Represent the 6 sets of particles in 2 dimensional array.
        int[][] particlesArr = new int[][]{
                {0, 2, 0, 2},
                {1, 3, 1, 3},
                {1, 5, 0, 3},
                {3, 3, 3, 3},
                {8, 8, 6, 7},
                {8, 8, 8, 8}};
        nukit(particlesArr);
    }

    public static void nukit(int[][] particlesArr) {
        int[] particles = {};
        String input = null;
        // Loop through the whole sets of particles - array
        for (int i = 0; i < particlesArr.length; i++) {
            // Ge a set of particles
            particles = particlesArr[i];
            // Format the input string for logging purpose only
            input = String.format("  %1$d %2$d %3$d %4$d", particles[0], particles[1], particles[2], particles[3]);
            log(input);

            // Reset the flag for each set of particles
            isPatrickWinner = false;
            // Check the set to see if Patrick is the winner
            boolean patrickWon = isPatrickWinner(particles[0], particles[1], particles[2], particles[3]);

            if (patrickWon) {
                log("Patrick");
            } else {
                log("Roland");
            }

            log("########################");
        }
    }

    private static boolean isPatrickWinner(int a, int b, int c, int d) {
        int a1=a, b1=b, c1=c, d1=d;
        boolean found = false;

        if (a1-2 >= 0 && b1-1 >= 0 && d1-2 >=0) {
            isPatrickWinner = !isPatrickWinner;
            log("- reation: AABDD");
            a1 = a1-2;
            b1 = b1-1;
            d1 = d1-2;
            found = true;
        }

        if (a1-1 >= 0 && b1-1 >= 0 && c1-1 >= 0 && d1-1 >=0) {
            isPatrickWinner = !isPatrickWinner;
            log("- reation: ABCD");
            a1 = a1-1;
            b1 = b1-1;
            c1 = c1-1;
            d1 = d1-1;
            found = true;
        }

        if (c1-2 >= 0 && d1-1 >=0) {
            isPatrickWinner = !isPatrickWinner;
            log("- reation: CCD");
            c1 = c1-2;
            d1 = d1-1;
            found = true;
        }

        if (b1-3 >= 0) {
            isPatrickWinner = !isPatrickWinner;
            log("- reation: BBB");
            b1 = b1-3;
            found = true;
        }

        if (a1-1 >= 0 && d1-1 >=0) {
            isPatrickWinner = !isPatrickWinner;
            log("- reation: AD");
            a1 = a1-1;
            d1 = d1-1;
            found = true;
        }

        if (a1 > 0 || b1 > 0 || c1 > 0 || d1 > 0) {
            if (found) {
                // Recursive Call to continue checking ...
                isPatrickWinner(a1, b1, c1, d1);
            }
        }

        return isPatrickWinner;
    }

    private static void log(String s) {
        System.out.println(s);
    }
}