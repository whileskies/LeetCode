package p0069;

public class Solution {
    public int mySqrt0(int x) {
        long i = 1;

        while (i * i <= x) {
            i++;
        }

        return (int)(i - 1);
    }

    public int mySqrt1(int x) {
        int ret = 0;
        int left = 1, right = x;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                ret = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ret;
    }


    public int mySqrt(int x) {
        if (x == 0)
            return 0;

        double x0 = x, x1;

        while (true) {
            x1 = 0.5 * (x0 + x / x0);
            if (Math.abs(x1 - x0) < 1e-7) {
                break;
            }
            x0 = x1;
        }

        return (int) x1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.mySqrt(Integer.MAX_VALUE));
    }
}
