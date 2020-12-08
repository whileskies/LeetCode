package p283;

import java.util.Arrays;

public class Solution {
    public void moveZeroes(int[] nums) {
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[cur++] = nums[i];
            }
        }

        for (int i = cur; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        new Solution().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
