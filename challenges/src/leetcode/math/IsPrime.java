package leetcode.math;

public class IsPrime {

    public static boolean isPrime(int n){
        if(n < 2) return false;

        for(int i = 2; i*i <= n; i++){
            if((n % i) == 0){
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(Math.sqrt(12));
        System.out.println("1 is prime: " + isPrime(1));
        System.out.println("2 is prime: " + isPrime(2));
        System.out.println("3 is prime: " + isPrime(3));
        System.out.println("4 is prime: " + isPrime(4));
        System.out.println("5 is prime: " + isPrime(5));
        System.out.println("6 is prime: " + isPrime(6));
        System.out.println("7 is prime: " + isPrime(7));
        System.out.println("8 is prime: " + isPrime(8));
        System.out.println("9 is prime: " + isPrime(9));
        System.out.println("10 is prime: " + isPrime(10));
        System.out.println("11 is prime: " + isPrime(11));
        System.out.println("13 is prime: " + isPrime(13));
        System.out.println("33 is prime: " + isPrime(33));
    }
}
