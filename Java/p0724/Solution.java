package p0724;

import java.util.Arrays;

public class Solution {
    public int pivotIndex0(int[] nums) {
        int left = 0, right = 0;

        for (int num : nums) {
            right += num;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0) left += nums[i - 1];
            right -= nums[i];
            if (left == right)
                return i;
        }

        return -1;
    }

    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (2 * sum + nums[i] == total)
                return i;
            sum += nums[i];
        }

        return -1;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{};
        System.out.println(s.pivotIndex(nums));
    }
}
