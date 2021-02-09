package p0055;

public class Solution {

    //dfs
    public boolean canJump0(int[] nums) {
        boolean[] memo = new boolean[nums.length];
        boolean[] recorded = new boolean[nums.length];
        return dfs(nums, 0, memo, recorded);
    }

    private boolean dfs(int[] nums, int index, boolean[] memo, boolean[] recorded) {
        if (recorded[index])
            return memo[index];

        boolean ret = false;
        if (index >= nums.length - 1) {
            ret = true;
        } else {
            int x = nums[index];
            for (int i = 1; i <= x; i++) {
                ret |= dfs(nums, Math.min(index + i, nums.length - 1), memo, recorded);
            }
        }

        recorded[index] = true;
        memo[index] = ret;

        return ret;
    }


    //贪心
    public boolean canJump(int[] nums) {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i <= maxReach) {
                maxReach = Math.max(maxReach, i + nums[i]);
            }
            if (maxReach >= nums.length - 1)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{3, 2, 1, 0, 4};
        System.out.println(s.canJump(nums));
    }
}
