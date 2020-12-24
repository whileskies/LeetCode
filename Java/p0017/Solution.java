package p0017;

import java.util.*;

public class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<Integer, List<Character>> map = new HashMap<>();
        map.put(2, Arrays.asList('a', 'b', 'c'));
        map.put(3, Arrays.asList('d', 'e', 'f'));
        map.put(4, Arrays.asList('g', 'h', 'i'));
        map.put(5, Arrays.asList('j', 'k', 'l'));
        map.put(6, Arrays.asList('m', 'n', 'o'));
        map.put(7, Arrays.asList('p', 'q', 'r', 's'));
        map.put(8, Arrays.asList('t', 'u', 'v'));
        map.put(9, Arrays.asList('w', 'x', 'y', 'z'));

        List<List<Character>> sets = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            sets.add(map.get(digits.charAt(i) - '0'));
        }
        List<Character> path = new ArrayList<>();
        List<List<Character>> tmpRet = new ArrayList<>();

        dfs(sets, tmpRet, path, 0);

        List<String> ret = new ArrayList<>();
        for (List<Character> charList : tmpRet) {
            StringBuilder sb = new StringBuilder();
            for (char c : charList) {
                sb.append(c);
            }
            ret.add(sb.toString());
        }

        return ret;
    }

    private void dfs(List<List<Character>> sets, List<List<Character>> ret, List<Character> path, int level) {
        if (level == sets.size()) {
            ret.add(new ArrayList<>(path));
            return;
        }

        List<Character> cur = sets.get(level);
        for (int i = 0; i < cur.size(); i++) {
            path.add(cur.get(i));
            dfs(sets, ret, path, level + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> ret = s.letterCombinations("");
        System.out.println(ret);
    }
}
