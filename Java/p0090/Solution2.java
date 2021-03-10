package p0090;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);

        dfs(nums, 0, path, subsets);

        return subsets;
    }

    private void dfs(int[] nums, int start, List<Integer> path, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1])
                continue;
            path.add(nums[i]);
            dfs(nums, i + 1, path, subsets);
            path.remove(path.size() - 1);
        }
    }


    public static void main(String[] args) {

        Solution2 solution = new Solution2();
        int[] nums = new int[]{1, 2, 2};
        List<List<Integer>> subsets = solution.subsetsWithDup(nums);

        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
