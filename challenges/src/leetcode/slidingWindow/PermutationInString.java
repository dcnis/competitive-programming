package leetcode.slidingWindow;

/*
* 567. Permutation in String
* https://leetcode.com/problems/permutation-in-string/
* */
public class PermutationInString {

    public static boolean checkInclusion(String s1, String s2) {

        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;

        int[] count = new int[26];

        for(int i = 0; i < s1.length(); i++){
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }

        for (int i = len1; i < len2; i++) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - len1) - 'a']++;
            if (allZero(count)) return true;
        }

        return false;

    }

        private static boolean allZero(int[] count) {
            for (int i = 0; i < 26; i++) {
                if (count[i] != 0) return false;
            }
            return true;
        }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo")); // true

        System.out.println(checkInclusion("ab", "eidboaoo")); // false
        System.out.println(checkInclusion("ccc", "cbac")); // false

    }
}
