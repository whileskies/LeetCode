package p0096;

public class Solution {
    public int numTrees0(int n) {
        int[][] dp = new int[n + 2][n + 2];

        for (int i = 0; i <= n + 1; i++) {
            for (int j = 0; j <= n + 1; j++) {
                dp[i][j] = 1;
            }
        }
        for (int i = n; i >= 1; i--) {
            for (int j = i + 1; j <= n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += dp[i][k - 1] * dp[k + 1][j];
                }
                dp[i][j] = sum;
            }
        }

        return dp[1][n];
    }

    public int numTrees(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numTrees(10));
    }
}
