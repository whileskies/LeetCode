package p0122;

public class Solution {
    public int maxProfit0(int[] prices) {
        if (prices.length == 0) return 0;
        int res = 0;
        int prePrice = 0;
        for (int i = 0; i < prices.length; i++) {
            int pre = i == 0 ? prices[0] : prices[i - 1];
            int cur = prices[i];
            int next = i == prices.length - 1 ? prices[prices.length - 1] : prices[i + 1];
            if (pre >= cur && cur < next) {
                prePrice = cur;
            } else if (cur > pre && cur >= next) {
                res += cur - prePrice;
            }
        }

        return res;
    }

    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            res += Math.max(0, prices[i] - prices[i - 1]);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] prices = new int[]{7, 6, 5, 4, 3, 1};
        System.out.println(s.maxProfit(prices));
    }
}
