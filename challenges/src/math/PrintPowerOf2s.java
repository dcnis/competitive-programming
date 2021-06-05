package math;

public class PrintPowerOf2s {

    private static int printPowerOf2(int n){

        if(n == 1) return 1;

        int prev = printPowerOf2(n/2);
        int curr = prev * 2;
        System.out.println(curr);
        return curr;
    }


    public static void main(String[] args) {
        printPowerOf2(100);
    }
}
