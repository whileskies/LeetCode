package p0377;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
//    public int combinationSum4(int[] nums, int target) {
//        int n = nums.length;
//        int[][] dp = new int[n + 1][target + 1];
//
//        Arrays.fill(dp[0], 0);
//        dp[0][0] = 1;
//        for (int i = 1; i <= n; i++) {
//            for (int j = 0; j <= target; j++) {
//                dp[i][j] = 0;
//                for (int k = 0; j - k * nums[i - 1] >= 0; k++) {
//                    dp[i][j] += dp[i - 1][j - k * nums[i - 1]];
//                }
//            }
//        }
//
//        for (int i = 0; i <= n; i++) {
//            for (int j = 0; j <= target; j++) {
//                System.out.println("(" + i + ", " + j + "): " + dp[i][j]);
//            }
//        }
//
//        return dp[n][target];
//    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            dp[i] = 0;
            for (int n : nums) {
                if (i >= n)
                    dp[i] += dp[i - n];
            }
        }

        return dp[target];
    }



    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1, 2, 3};
        System.out.println(s.combinationSum4(nums, 4));
    }

}
