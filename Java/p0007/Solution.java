package p0007;

public class Solution {
    public int reverse(int x) {
        int ret = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            if (ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && digit > 7))
                return 0;
            if (ret < Integer.MIN_VALUE / 10 || (ret == Integer.MIN_VALUE / 10 && digit < -8))
                return 0;
            ret = ret * 10 + digit;
        }

        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int num = Integer.MIN_VALUE;
        System.out.println(num + " " + s.reverse(num));
    }
}
