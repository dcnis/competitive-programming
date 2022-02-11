package leetcode.DP;

public class ZeroOneKnapsackProblem {

    static final int[] values = new int[] { 60, 100, 120 };
    static final int[] weights = new int[] { 10, 20, 30 };

    public static void main(String[] args) {
        System.out.println(knapSack(0, 50, values.length-1));
    }


    static int knapSack(int total, int currentCapacity, int i){

        if(currentCapacity <= 0) return total;
        if(i < 0) return total;

        // we take it
        int taken = knapSack(total + values[i], currentCapacity - weights[i], i - 1);
        int notTaken = knapSack(total, currentCapacity, i - 1);

        return Math.max(taken, notTaken);
    }
}
