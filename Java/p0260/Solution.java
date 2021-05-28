package p0260;

import java.util.Arrays;

public class Solution {
    public int[] singleNumber(int[] nums) {
        int sum = 0;
        for (int n : nums)
            sum ^= n;

//        int div = 1;
//        while ((div & sum) == 0)
//            div <<= 1;
        int div = sum & (-sum);

        int a = 0, b = 0;
        for (int n : nums) {
            if ((n & div) != 0)
                a ^= n;
            else
                b ^= n;
        }

        return new int[] {a, b};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1, 2, 1, 3, 2, 5};
        System.out.println(Arrays.toString(s.singleNumber(nums)));
    }
}
