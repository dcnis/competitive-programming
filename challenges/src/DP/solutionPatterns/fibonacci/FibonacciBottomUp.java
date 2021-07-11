package DP.solutionPatterns.fibonacci;

public class FibonacciBottomUp {

    public static int fibo(int nth){
        if(nth == 0) return 0;
        if(nth == 1) return 1;
        if(nth == 2) return 1;

        int[] arr = new int[nth+1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;

        for(int i = 3; i < arr.length; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }

        return arr[nth];
    }

    public static void main(String[] args) {
        System.out.println(fibo(3));
        System.out.println(fibo(4));
        System.out.println(fibo(5));
        System.out.println(fibo(6));
        System.out.println(fibo(7));
    }

}
