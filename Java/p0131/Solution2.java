package p0131;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    //dp预处理

    private boolean[][] dp;

    private void prepare(String s) {
        int n = s.length();
        dp = new boolean[n][n];

        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], true);

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();

        prepare(s);
        dfs(s, 0, path, res);

        return res;
    }

    private void dfs(String s, int b, List<String> path, List<List<String>> res) {
        if (b == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int l = 1; l <= s.length() - b; l++) {
            String sub = s.substring(b, b + l);
            if (dp[b][b + l - 1]) {
                path.add(sub);
                dfs(s, b + l, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        List<List<String>> res = s.partition("aab");
        for (List<String> l : res) {
            System.out.println(l);
        }
    }
}
