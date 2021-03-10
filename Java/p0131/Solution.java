package p0131;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();

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
            if (isPal(sub)) {
                path.add(sub);
                dfs(s, b + l, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPal(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<String>> res = s.partition("aabbb");
        for (List<String> l : res) {
            System.out.println(l);
        }
    }
}
