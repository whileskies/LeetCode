package p0140;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private List<List<String>> res = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        dfs(s, 0, wordDict, new ArrayList<>());
        List<String> trueRes = new ArrayList<>();
        for (List<String> list : res) {
            trueRes.add(String.join(" ", list));
        }

        return trueRes;
    }


    private void dfs(String s, int b, List<String> wordDict, List<String> path) {
        if (b >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int e = b + 1; e <= s.length(); e++) {
            String sub = s.substring(b, e);
            if (wordDict.contains(sub)) {
                path.add(sub);
                dfs(s, e, wordDict, path);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> wordDict = List.of("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
        List<String> res = s.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", wordDict);
        for (String str : res) {
            System.out.println(str);
        }


    }
}
