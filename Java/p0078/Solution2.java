package p0078;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(nums, 0, path, subsets);

        return subsets;
    }

    private void dfs(int[] nums, int start, List<Integer> path, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i + 1, path, subsets);
            path.remove(path.size() - 1);
        }
    }


    public static void main(String[] args) {

        Solution2 solution = new Solution2();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> subsets = solution.subsets(nums);

        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
