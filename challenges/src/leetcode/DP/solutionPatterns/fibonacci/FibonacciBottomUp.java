package leetcode.DP.solutionPatterns.fibonacci;

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





    public static int fibo2(int n){

        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 1;

        int[] tabu = new int[n+1];
        tabu[0] = 0;
        tabu[1] = 1;
        tabu[2] = 1;

        for(int i = 3; i <= n; i++){
            tabu[i] = tabu[i-1] + tabu[i-2];
        }

        return tabu[n];
    }


    public static void main(String[] args) {
        System.out.println(fibo2(3)); // 2
        System.out.println(fibo2(4)); // 3
        System.out.println(fibo2(5)); // 5
        System.out.println(fibo2(6)); // 8
        System.out.println(fibo2(7)); // 13
    }

}
