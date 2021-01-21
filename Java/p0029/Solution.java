package p0029;

public class Solution {
    public int divide(int dividend, int divisor) {
        int sign = (dividend > 0 ? 1 : -1) * (divisor > 0 ? 1 : -1);
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);

        long cnt = 0;
        while (a >= b) {
            long sum = b;
            long num = 1;
            while (sum <= a) {
                a -= sum;
                cnt += num;
                sum += sum;
                num += num;
            }

        }

        long ret = sign * cnt;
        if (ret > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (ret < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return (int) ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(s.divide(Integer.MAX_VALUE, -1));
        System.out.println(s.divide(100, 1));
    }
}
