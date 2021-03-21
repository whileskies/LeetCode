package contest.p5704;

public class Solution {
    public int maximumScore(int[] nums, int k) {
        int res = -1;

        for (int i = k; i >= 0; i--) {

            for (int j = k; j < nums.length; j++) {
                int min = getMin(nums, i, j);
                int score = min * (j - i + 1);
                res = Math.max(score, res);
            }
        }

        return res;
    }

    private int getMin(int[] nums, int i, int j) {
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            min = Math.min(min, nums[k]);
        }
        return min;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maximumScore(new int[]{5, 5, 4, 5, 4, 1, 1, 1}, 0));
    }
}
