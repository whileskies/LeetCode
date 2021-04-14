package p0154;

public class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int m = (l + r) / 2;

            if (nums[m] > nums[r]) {
                l = m + 1;
            } else if (nums[m] < nums[r]){
                r = m;
            } else {
                r--;
            }
        }

        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 1, 3};
        System.out.println(new Solution().findMin(nums));
    }
}
