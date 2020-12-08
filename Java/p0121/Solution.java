package p0121;

public class Solution {
    public int maxProfit1(int[] prices) {
        int maxP = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < i; j++) {
                maxP = Math.max(maxP, prices[i] - prices[j]);
            }
        }
        return maxP;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 1) return 0;
        int[] r = new int[n];
        r[0] = 0;
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            r[i] = Math.max(r[i - 1], prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }

        return r[n - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] prices = new int[]{7};
        System.out.println(s.maxProfit(prices));
    }
}
