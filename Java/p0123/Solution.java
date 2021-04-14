package p0123;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int n = prices.length;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        int minp = prices[0];
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i - 1] - minp);
            minp = Math.min(minp, prices[i - 1]);
        }

//        int[] dp2 = new int[n + 2];
//        dp2[n + 1] = 0;
//        int maxp = prices[n - 1];
//        for (int i = n; i >= 1; i--) {
//            dp2[i] = Math.max(dp2[i + 1], maxp - prices[i - 1]);
//            maxp = Math.max(maxp, prices[i - 1]);
//        }


        int res = 0;
        int maxp = prices[n - 1];
        for (int i = n; i >= 1; i--) {
            res = Math.max(res, maxp - prices[i - 1] + dp[i]);
            maxp = Math.max(maxp, prices[i - 1]);
        }
//        for (int i = 1; i <= n; i++) {
//            res = Math.max(res, dp[i] + dp2[i]);
//        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] prices = new int[]{1,2,4,2,5,7,2,4,9,0};
        System.out.println(s.maxProfit(prices));
    }
}
