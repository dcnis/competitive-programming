package leetcode.bitmanipulation;

/*
* 231. Power of Two
* https://leetcode.com/problems/power-of-two/
* */
public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {

        if(n == 0) return false;


        return n == (n & -n);
    }

    public static void main(String[] args) {
        int n = Integer.MIN_VALUE;

        System.out.println((n & (-n)) == n);
    }
}
