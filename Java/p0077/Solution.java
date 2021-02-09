package p0077;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(n, k, 1, path, ans);

        return ans;
    }

    private void dfs(int n, int k, int cur, List<Integer> path, List<List<Integer>> ans) {
        if (n - cur + 1 < k - path.size()) {
            return;
        }

        if (path.size() == k){
            ans.add(new ArrayList<>(path));
            return;
        }

        path.add(cur);
        dfs(n, k, cur + 1, path, ans);
        path.remove(path.size() - 1);
        dfs(n, k, cur + 1, path, ans);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> ret = s.combine(4, 2);
        for (List<Integer> l : ret) {
            System.out.println(l);
        }
    }
}
