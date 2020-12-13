package p0063;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0) return 0;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        boolean block = false;
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1)
                block = true;
            dp[i][0] = block ? 0 : 1;
        }

        block = false;
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1)
                block = true;
            dp[0][j] = block ? 0 : 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] obstacleGrid = new int[][]{
                {0, 0},
                {0, 1}
        };

        System.out.println(s.uniquePathsWithObstacles(obstacleGrid));
    }
}
