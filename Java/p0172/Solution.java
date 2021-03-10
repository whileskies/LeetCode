package p0172;

public class Solution {
    public int trailingZeroes(int n) {
        int d5 = 0;
        for (int i = 1; i <= n; i++) {
            int x = i;
            while (x % 5 == 0) {
                x /= 5;
                d5++;
            }
        }

        return d5;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.trailingZeroes(5));
    }
}
