package p0198;

public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{2, 7, 9, 3, 1};
        System.out.println(s.rob(nums));
    }
}
