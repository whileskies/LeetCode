package p5711;

import java.util.Arrays;

public class Solution {
    private long getSum(long len, long x) {
        long sum;
        if (x > len) {
            sum = (x + x - len + 1) * len / 2;
        } else {
            sum = (x + 1) * x / 2 + len - x;
        }

        return sum;
    }

    public int maxValue(int n, int index, int maxSum) {

        int l = 1, r = maxSum;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            long sum = getSum(index + 1, mid) + getSum(n - index, mid) - mid;
            if (sum <= maxSum)
                l = mid;
            else
                r = mid - 1;
        }

        return l;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxValue(6, 2,931384943));
//        System.out.println(s.getSum(2, 8, 5));
    }
}
