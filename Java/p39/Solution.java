package p39;

import java.util.*;

public class Solution {
    /*private List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>();

        for (int i = 0; i < candidates.length; i++) {
            dfs(candidates, target, i, path);
        }

        return ret;
    }


    public void dfs(int[] candidates, int target, int index, List<Integer> path) {
        path.add(candidates[index]);
        int sum = 0;
        for (int elem : path) {
            sum += elem;
        }
        if (sum == target) {
            ret.add(new ArrayList<>(path));
        } else if (sum < target){
            for (int j = index; j < candidates.length; j++) {
                dfs(candidates, target, j, path);
            }
        }
        path.remove(path.size() - 1);
    }*/

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();

        dfs(candidates, target, 0, path, res);

        return res;
    }


    public void dfs(int[] candidates, int target, int start, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
        } else if (target > 0) {
            for (int i = start; i < candidates.length; i++) {
                if (candidates[i] > target)
                    break;
                path.addLast(candidates[i]);
                dfs(candidates, target - candidates[i], i, path, res);
                path.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        Solution s = new Solution();
        List<List<Integer>> ret = s.combinationSum(candidates, 7);

        for (List<Integer> list : ret) {
            System.out.println(list);
        }


    }
}
