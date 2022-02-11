package leetcode.DP;

public class InterleavingString {

    public static boolean isInterleave(String s1, String s2, String s3) {

        if(s3.length() != (s1.length() + s2.length())) return false;

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();
        int m = s1.length();
        int n = s2.length();

        return dfs(c1, c2, c3, 0,0,0 , new int[m+1][n+1]);

    }

    private static boolean dfs(char[] c1, char[] c2, char[] c3, int i, int j, int x, int[][] invalid){

        if(invalid[i][j] == -1) return false;
        if(invalid[i][j] == 1) return true;
        if(x == c3.length) return true;

        boolean tookLeft = false;
        boolean tookRight = false;
        if(i < c1.length && c1[i] == c3[x]){
            tookLeft =  dfs(c1, c2, c3, i+1, j, x+1, invalid);
        }
        if(j < c2.length  && c2[j] == c3[x]){
            tookRight = dfs(c1, c2, c3, i, j+1, x+1, invalid);
        }

        boolean valid = tookLeft || tookRight;

        if(!valid){
            invalid[i][j] = -1;
        } else {
            invalid[i][j] = 1;
        }

        return valid;
    }

    public static void main(String[] args) {

        // should return true
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";


        System.out.println(isInterleave(s1, s2, s3));

        // should return false
        s1 = "aabcc";
        s2 = "dbbca";
        s3 = "aadbbbaccc";

        System.out.println(isInterleave(s1, s2, s3));

        // should return true
        s3 = "";
        s1 = "";
        s2 = "";

        System.out.println(isInterleave(s1, s2, s3));

        // should return false
        s1 = "b";
        s2 = "a";
        s3 = "a";

        System.out.println(isInterleave(s1, s2, s3));


        // should return true
        s1 = "aa";
        s2 = "ab";
        s3 = "aaba";

        System.out.println(isInterleave(s1, s2, s3));
    }

}
