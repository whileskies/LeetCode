import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while (i > 0 && nums[i - 1] >= nums[i]) { i--; };

        if (i > 0) {
            int j = i - 1;
            int k = nums.length;
            while (nums[--k] <= nums[j]);
            swap(nums, j, k);
        }

        int j = i, k = nums.length - 1;
        for (; j < (i + nums.length) / 2; j++, k--) {
            swap(nums, j, k);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }


    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 8, 5, 7, 6, 4};
        new Solution().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
