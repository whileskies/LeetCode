package p0091;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    // dfs 超时
    public int numDecodings0(String s) {
        List<List<String>> ret = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(s, 0, path, ret);

        int cnt = 0;
        for (List<String> n : ret) {
            boolean canDecoded = true;
            for (String ch : n) {
                int num = Integer.parseInt(ch);
                if (ch.startsWith("0") || num < 1 || num > 26) {
                    canDecoded = false;
                    break;
                }
            }
            if (canDecoded)
                cnt++;
        }

        return cnt;
    }

    private void dfs(String s, int start, List<String> path, List<List<String>> ret) {
        if (start == s.length()) {
            ret.add(new ArrayList<>(path));
            return;
        }

        String sub = s.substring(start, start + 1);
        path.add(sub);
        dfs(s, start + 1, path, ret);
        path.remove(path.size() - 1);

        if (start <= s.length() - 2) {
            sub = s.substring(start, start + 2);
            path.add(sub);
            dfs(s, start + 2, path, ret);
            path.remove(path.size() - 1);
        }
    }


    //dp
    public int numDecodings1(String s) {
        int n = s.length();
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            if (valid(s.substring(i, i + 1))) {
                dp[i] += i > 0 ? dp[i - 1] : 1;
            }
            if (i > 0 && valid(s.substring(i - 1, i + 1))) {
                dp[i] += i > 1 ? dp[i - 2] : 1;
            }
        }

        return dp[n - 1];
    }

    private boolean valid(String s) {
        int num = Integer.parseInt(s);
        return !s.startsWith("0") && num >= 1 && num <= 26;
    }


    public int numDecodings(String s) {
        if (s.charAt(0) == '0')
            return 0;

        int pre = 1, cur = 1;

        for (int i = 1; i < s.length(); i++) {
            int tmp = cur;

            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2')
                    cur = pre;
                else
                    return 0;
            } else {
                if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) >= '0' && s.charAt(i) <= '6')) {
                    cur = cur + pre;
                }
            }

            pre = tmp;
        }

        return cur;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numDecodings("1111111111"));
    }
}
