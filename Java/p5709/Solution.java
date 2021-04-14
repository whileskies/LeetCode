package p5709;

public class Solution {
    public int maxAscendingSum(int[] nums) {
        int res = -1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] > nums[i - 1]) {
                sum += nums[i];
            } else {
                res = Math.max(res, sum);
                sum = nums[i];
            }
        }

        return Math.max(res, sum);
    }
}
