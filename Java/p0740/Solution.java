package p0740;

import java.util.Arrays;

public class Solution {
    public int deleteAndEarn0(int[] nums) {
        int MAX = 10001;
        int[] cnt = new int[MAX];
        Arrays.fill(cnt, 0);
        for (int n : nums) {
            cnt[n]++;
        }

        int[] dp = new int[MAX];
        dp[0] = 0;
        dp[1] = cnt[1];
        for (int i = 2; i < MAX; i++) {
            dp[i] = Math.max(dp[i - 2] + i * cnt[i], dp[i - 1]);
        }

        return dp[MAX - 1];
    }

    public int deleteAndEarn(int[] nums) {
        int MAX = 10001;
        int[] cnt = new int[MAX];
        int[][] dp = new int[MAX][2];
        Arrays.fill(cnt, 0);
        for (int i = 0; i < MAX; i++) Arrays.fill(dp[i], 0);
        for (int n : nums) {
            cnt[n]++;
        }

        for (int i = 1; i < MAX; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + i * cnt[i];
        }

        return Math.max(dp[MAX - 1][0], dp[MAX - 1][1]);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1, 1, 1, 2, 4, 5, 5, 5, 6};
        System.out.println(s.deleteAndEarn(nums));
    }
}
