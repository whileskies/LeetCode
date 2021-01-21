package p0017;

import java.util.*;

public class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<Integer, String> map = new HashMap<>() {{
            put(2, "abc");
            put(3, "def");
            put(4, "ghi");
            put(5, "jkl");
            put(6, "mno");
            put(7, "pqrs");
            put(8, "tuv");
            put(9, "wxyz");
        }};

        List<String> sets = new ArrayList<>();

        for (int i = 0; i < digits.length(); i++) {
            sets.add(map.get(digits.charAt(i) - '0'));
        }
        StringBuilder path = new StringBuilder();
        List<String> ret = new ArrayList<>();

        dfs(sets, ret, path, 0);

        return ret;
    }

    private void dfs(List<String> sets, List<String> ret, StringBuilder path, int level) {
        if (level == sets.size()) {
            ret.add(String.valueOf(path));
            return;
        }

        String cur = sets.get(level);
        for (int i = 0; i < cur.length(); i++) {
            path.append(cur.charAt(i));
            dfs(sets, ret, path, level + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> ret = s.letterCombinations("23456789");
        System.out.println(ret);
    }
}
