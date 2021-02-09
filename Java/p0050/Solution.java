package p0050;

public class Solution {
    public double quickPow0(double x, long y) {
        double ret = 1;
        double base = x;
        while (y > 0) {
            if ((y & 1) == 1) {
                ret *= base;
            }
            base *= base;
            y >>= 1;
        }

        return ret;
    }

    public double quickPow(double x, long y) {
        if (y == 0) return 1.0;
        double t = quickPow(x, y / 2);
        return (y & 1) == 0 ? t * t : t * t * x;
    }

    public double myPow(double x, int n) {
        long y = n;
        return y > 0 ? quickPow(x, y) : 1.0 / quickPow(x, -y);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.myPow(2, 10));
    }
}
