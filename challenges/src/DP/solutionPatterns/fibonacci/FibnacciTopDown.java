package DP.solutionPatterns.fibonacci;

public class FibnacciTopDown {

    public static int fibo(int nth){
        if(nth == 0) return 0;
        if(nth == 1) return 1;
        if(nth == 2) return 1;

        return fibo(nth-1) + fibo(nth-2);
    }

    public static void main(String[] args) {
        System.out.println(fibo(3));
        System.out.println(fibo(4));
        System.out.println(fibo(5));
        System.out.println(fibo(6));
        System.out.println(fibo(7));
    }

}
