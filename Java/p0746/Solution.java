package p0746;

public class Solution {
    public int minCostClimbingStairs0(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }

        return Math.min(dp[n - 1], dp[n - 2]);
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int first = cost[0];
        int second = cost[1];

        for (int i = 2; i < n; i++) {
            int cur = Math.min(first, second) + cost[i];
            first = second;
            second = cur;
        }

        return Math.min(first, second);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(s.minCostClimbingStairs(cost));
    }
}
