package p47;

import java.util.*;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();

        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];

        dfs(nums, visited, path, res);

        return new ArrayList<>(res);
    }

    public void dfs(int[] nums, boolean[] visited, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1])
                    continue;
                visited[i] = true;
                path.addLast(nums[i]);
                dfs(nums, visited, path, res);
                visited[i] = false;
                path.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2};
        Solution s = new Solution();
        List<List<Integer>> res = s.permuteUnique(nums);

        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }
}
