package p0090;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        Arrays.sort(nums);

        dfs(nums, 0, path, ret);

        return ret;
    }

    private void dfs(int[] nums, int index, List<Integer> path, List<List<Integer>> ret) {
        if (index == nums.length) {
            ret.add(new ArrayList<>(path));
            return;
        }

        path.add(nums[index]);
        dfs(nums, index + 1, path, ret);
        path.remove(path.size() - 1);

        if (path.size() == 0 || path.get(path.size() - 1) != nums[index])
            dfs(nums, index + 1, path, ret);
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{4, 4, 4, 1, 4};
        List<List<Integer>> ret = s.subsetsWithDup(nums);
        for (List<Integer> l : ret) {
            System.out.println(l);
        }
    }
}
