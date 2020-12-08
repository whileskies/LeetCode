package p0153;

public class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 2};
        System.out.println(new Solution().findMin(nums));
    }
}
