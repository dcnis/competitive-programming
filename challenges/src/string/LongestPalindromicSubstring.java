package string;

public class LongestPalindromicSubstring {

    public static String longestPalindromicSubstring(String str) {
        // Write your code here.
        if(str.length() == 1) return str;

        String longestPalindrome = "";
        int maxSubstring = Integer.MIN_VALUE;
        for(int i = 1; i < str.length(); i++){
            // Letter in the middle
            String fromChar = findMaxPalindromeFrom(i-1, i+1, str);
            if(fromChar.length() > longestPalindrome.length()){
                longestPalindrome = fromChar;
            }

            String fromSpace = findMaxPalindromeFrom(i-1, i, str);
            if(fromSpace.length() > longestPalindrome.length()){
                longestPalindrome = fromSpace;
            }

        }

        return longestPalindrome;
    }

    private static String findMaxPalindromeFrom(int i, int j, String str){
        if(i < 0 ) return "";
        if(j > str.length()-1) return "";
        if(str.charAt(i) != str.charAt(j)) return "";

        while(i >= 0 && j <= (str.length()-1) && str.charAt(i) == str.charAt(j)){
            i--;
            j++;
        }

        return str.substring(i+1, j);
    }

    public static void main(String[] args) {

        // should output xyzzyx
        System.out.println(longestPalindromicSubstring("abaxyzzyxf"));

        // should output noon
        System.out.println(longestPalindromicSubstring("it's highnoon"));
    }
}
