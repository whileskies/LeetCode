package p0077;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(n, k, 1, path, ans);

        return ans;
    }

    private void dfs(int n, int k, int begin, List<Integer> path, List<List<Integer>> ans) {
        if (n - begin + 1 < k - path.size())
            return;

        if (path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i <= n; i++) {
            path.add(i);
            dfs(n, k, i + 1, path, ans);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        List<List<Integer>> ret = s.combine(4, 3);
        for (List<Integer> l : ret) {
            System.out.println(l);
        }
    }
}
