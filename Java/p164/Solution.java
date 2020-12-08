package p164;

import java.util.Arrays;

public class Solution {
    public int maximumGap1(int[] nums) {
        if (nums.length < 2)
            return 0;

        Arrays.sort(nums);

        int gap = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > gap) {
                gap = nums[i] - nums[i - 1];
            }
        }

        return gap;
    }

    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2)
            return 0;
        int base = 1;
        int maxVal = Arrays.stream(nums).max().getAsInt();

        while (base <= maxVal) {
            int[] count = new int[10];
            for (int num : nums) {
                int digit = (num / base) % 10;
                count[digit]++;
            }
            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }

            int[] tmp = new int[n];
            for (int i = n - 1; i >= 0; i--) {
                int num = nums[i];
                int digit = (num / base) % 10;
                tmp[count[digit] - 1] = num;
                count[digit]--;
            }

            System.arraycopy(tmp, 0, nums, 0, n);
            base *= 10;
        }

        int gap = 0;
        for (int i = 1; i < n; i++) {
            gap = Math.max(gap, nums[i] - nums[i - 1]);
        }

        return gap;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{3, 6, 9, 1};
        // 0 2 5 8
        System.out.println(s.maximumGap(nums));
    }
}
