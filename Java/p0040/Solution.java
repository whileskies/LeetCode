package p0040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        Arrays.sort(candidates);
        dfs(candidates, 0, target, path, ret);

        return ret;
    }

    private void dfs(int[] candidates, int start, int target, List<Integer> path, List<List<Integer>> ret) {
        if (target == 0) {
            ret.add(new ArrayList<>(path));
        } else if (target > 0) {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1])
                    continue;
                if (candidates[i] > target)
                    break;
                path.add(candidates[i]);
                dfs(candidates, i + 1, target - candidates[i], path, ret);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> ret = s.combinationSum2(candidates, 8);
        for (List<Integer> list : ret) {
            System.out.println(list);
        }
    }
}
