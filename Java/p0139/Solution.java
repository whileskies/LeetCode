package p0139;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];

        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            String sub = s.substring(0, i);
            dp[i] = false;
            for (String word : wordDict) {
                if (sub.endsWith(word) && dp[i - word.length()]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> wordDict = List.of("leet2", "code");
        System.out.println(s.wordBreak("leetcode", wordDict));
    }
}
