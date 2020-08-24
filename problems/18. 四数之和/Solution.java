import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    //初始版
    public List<List<Integer>> fourSum1(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int l = j + 1;
                int r = nums.length - 1;

                while (l < r) {
                    int subTarget = target - nums[i] - nums[j];
                    if (nums[l] + nums[r] == subTarget) {
                        ret.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[++l]);
                        while (l < r && nums[r] == nums[--r]);
                    } else if (nums[l] + nums[r] < subTarget) {
                        while (l < r && nums[l] == nums[++l]);
                    } else {
                        while (l < r && nums[r] == nums[--r]);
                    }
                }

            }
        }

        return ret;
    }

    //优化版，通过剪枝进行优化，不进行无用计算
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            //以nums[i]为首的四元组最小值比target还大，以后只会更大，直接退出
            int mini = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            //以nums[i]为首的四元组最大值比target还小，尝试更大的nums[i]
            if (mini > target) break;
            int maxi = nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3];
            if (maxi < target) continue;

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int l = j + 1;
                int r = nums.length - 1;

                int minij = nums[i] + nums[j] + nums[l] + nums[l + 1];
                if (minij > target) break;

                int maxij = nums[i] + nums[j] + nums[r] + nums[r - 1];
                if (maxij < target) continue;

                while (l < r) {
                    int subTarget = target - nums[i] - nums[j];
                    if (nums[l] + nums[r] == subTarget) {
                        ret.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[++l]);
                        while (l < r && nums[r] == nums[--r]);
                    } else if (nums[l] + nums[r] < subTarget) {
                        while (l < r && nums[l] == nums[++l]);
                    } else {
                        while (l < r && nums[r] == nums[--r]);
                    }
                }

            }
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-3, -2, -1, 0, 0, 1, 2, 3};
        List<List<Integer>> ret = new Solution().fourSum(nums, 0);
        for (List<Integer> e : ret) {
            System.out.println(e);
        }
    }
}
