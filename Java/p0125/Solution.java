package p0125;

public class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!(Character.isDigit(ci) || Character.isAlphabetic(ci))) {
                i++; continue;
            }
            if (!(Character.isDigit(cj) || Character.isAlphabetic(cj))) {
                j--; continue;
            }

            ci = Character.toLowerCase(ci);
            cj = Character.toLowerCase(cj);
            if (ci != cj)
                return false;

            i++; j--;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPalindrome("race a car"));
    }
}
