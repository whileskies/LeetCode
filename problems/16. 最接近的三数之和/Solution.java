import java.util.Arrays;

public class Solution {
    //第一版，可直接将差值比较移到每次双指针移动，代码会简洁些
    public int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = 0;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int subTarget = target - nums[i];

            int j = i + 1, k = nums.length - 1;
            int subClosestSum = 0;
            int subMinDiff = Integer.MAX_VALUE;
            while (j < k) {
                int curSubDiff = Math.abs(nums[j] + nums[k] - subTarget);
                if (curSubDiff < subMinDiff) {
                    subMinDiff = curSubDiff;
                    subClosestSum = nums[j] + nums[k];
                }
                if (nums[j] + nums[k] == subTarget) {
                    break;
                } else if (nums[j] + nums[k] < subTarget) {
                    while (j < k && nums[j] == nums[++j]);
                } else {
                    while (j < k && nums[k] == nums[--k]);
                }
            }

            int curDiff = Math.abs(subClosestSum + nums[i] - target);
            if (curDiff < minDiff) {
                minDiff = curDiff;
                closestSum = subClosestSum + nums[i];
            }
        }

        return closestSum;
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = 10000000;

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int j = i + 1,  k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }

                if (sum == target) {
                    break;
                } else if (sum < target) {
                    while (j < k && nums[j] == nums[++j]);
                } else {
                    while (j < k && nums[k] == nums[--k]);
                }
            }
        }

        return closestSum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, -1, -1, 3};
        System.out.println(new Solution().threeSumClosest(nums, -1));

    }
}
