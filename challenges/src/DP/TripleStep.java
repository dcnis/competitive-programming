package DP;

public class TripleStep {

    /* A child running up a staircase with n steps and can hop either 1, 2 or 3 steps at a time. Implement a method to count how many
    possible ways the child can run up the stairs. */

    public static int stairs(int n){

        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(n == 3) return 4;

        return stairs(n-3) + stairs(n-2) + stairs(n-1);
    };


    public static void main(String[] args) {

        System.out.println(stairs(4));

    }
}
