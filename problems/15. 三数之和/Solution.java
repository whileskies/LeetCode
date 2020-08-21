import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target = -nums[i];

            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    ret.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[++j]);
                    while (j < k && nums[k] == nums[--k]);
                } else if (nums[j] + nums[k] < target) {
                    while (j < k && nums[j] == nums[++j]);
                } else {
                    while (j < k && nums[k] == nums[--k]);
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        //int[] nums = new int[] {-1, 0, 1, 2, -1, -4};
        int[] nums = new int[] {0, 0, 0, 0, 0};
        List<List<Integer>> ret = new Solution().threeSum(nums);
        for (List<Integer> e : ret) {
            System.out.println(e);
        }
    }
}