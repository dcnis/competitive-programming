package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Temp {

    public static void main(String[] args) {

        FastScanner fs = new FastScanner();
        int tests = fs.nextInt();
        for(int i = 0; i < tests; i++){
            int n = fs.nextInt();
            char[] str = fs.next().toCharArray();

            char[] copy = str.clone();
            Arrays.sort(copy);
            int ans = 0;
            for(int j = 0; j < str.length; j++){
                if(str[j] != copy[j]){
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }

    static class FastScanner{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public String next() {
            while(!st.hasMoreTokens()){
                try{
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt(){
            return Integer.parseInt(next());
        }

    }
}
