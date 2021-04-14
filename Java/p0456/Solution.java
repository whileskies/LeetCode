package p0456;

public class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) return false;

        int leftMin = nums[0];
        for (int j = 1; j < nums.length - 1; j++) {
            for (int k = j + 1; k < nums.length; k++) {
                if (nums[k] < nums[j] && nums[k] > leftMin) {
                    return true;
                }
            }

            leftMin = Math.min(leftMin, nums[j]);
        }

        return false;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{2, 8, 2, 8};
        System.out.println(s.find132pattern(nums));
    }
}
