package p9;

public class Solution {
    public boolean isPalindrome1(int x) {
        return Integer.toString(x).equals(new StringBuffer(Integer.toString(x)).reverse().toString());
    }

    public boolean isPalindrome2(int x) {
        if (x < 0)
            return false;
        int r = 0, ori = x;
        int base = 10;
        while (x > 0) {
            r = r * base + x % 10;
            x /= 10;
        }

        return ori == r;
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;
        int reverseNum = 0;
        while (x > reverseNum) {
            reverseNum = reverseNum * 10 + x % 10;
            x /= 10;
        }

        return x == reverseNum || x == reverseNum / 10;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPalindrome(10));
    }
}
