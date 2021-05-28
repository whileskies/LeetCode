package p0368;

import java.util.*;

public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int maxIndex = 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] > dp[maxIndex])
                        maxIndex = i;
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        while (true) {
            res.add(nums[maxIndex]);
            if (dp[maxIndex] == 1)
                break;
            for (int i = 0; i < maxIndex; i++) {
                if (nums[maxIndex] % nums[i] == 0 && dp[maxIndex] == dp[i] + 1) {
                    maxIndex = i;
                    break;
                }
            }
        }

        return res;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1, 2, 4, 8, 10, 12, 15, 20};
        System.out.println(s.largestDivisibleSubset(nums));
    }
}
