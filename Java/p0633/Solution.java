package p0633;

public class Solution {
    public boolean judgeSquareSum(int c) {
        for (int a = 0; a * a <= c && c - a * a >= 0; a++) {
            int b2 = c - a * a;
            double b = Math.sqrt(b2);
            if ((int) b * (int) b == b2) {
                //System.out.println(a + " " + b);
                return true;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.judgeSquareSum(Integer.MAX_VALUE));
    }
}
