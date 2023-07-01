package de.schmidtdennis.challenges.leetcode.bitmanipulation;

// 190. Reverse Bits
public class ReverseBits {


    public static int reverseBits(int n) {

        int result = 0;

        for(int i = 0; i < 32; i++){
            int bit = n & 1;
            if(bit == 1){
                result = result + bit;
            }

            result = result << 1;
            n = n >> 1;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(13));
    }

}
