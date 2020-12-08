package p46;

import java.util.*;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();

        boolean[] visited = new boolean[nums.length];

        dfs(nums, visited, path, res);

        return res;
    }

    public void dfs(int[] nums, boolean[] visited, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path.addLast(nums[i]);
                dfs(nums, visited, path, res);
                visited[i] = false;
                path.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Solution s = new Solution();
        List<List<Integer>> res = s.permute(nums);

        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }
}
