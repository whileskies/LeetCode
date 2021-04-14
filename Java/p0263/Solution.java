package p0263;

public class Solution {
    public boolean isUgly(int n) {
        if (n <= 0) return false;
        while (n % 2 == 0)
            n /= 2;
        while (n % 3 == 0)
            n /= 3;
        while (n % 5 == 0)
            n /= 5;

        return n == 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isUgly(-1000));
    }
}
