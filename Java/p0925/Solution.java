package p0925;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    static class Pair {
        char ch;
        int cnt;
    }


    public boolean isLongPressedName(String name, String typed) {
        List<Pair> nameCharCnt = getCharCnt(name);
        List<Pair> typedCharCnt = getCharCnt(typed);

        if (nameCharCnt.size() != typedCharCnt.size())
            return false;

        for (int i = 0; i < nameCharCnt.size(); i++) {
            Pair n = nameCharCnt.get(i);
            Pair t = typedCharCnt.get(i);

            if (n.ch != t.ch || t.cnt < n.cnt)
                return false;
        }

        return true;
    }

    private List<Pair> getCharCnt(String str) {
        List<Pair> pairs = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i + 1;
            while (j < str.length() && str.charAt(i) == str.charAt(j)) { j++; }

            Pair p = new Pair();
            p.ch = str.charAt(i);
            p.cnt = j - i;
            pairs.add(p);

            i = j;
        }
        return pairs;
    }

    public static void main(String[] args) {
        String name = "laiden";
        String typed = "laiden";
        Solution s = new Solution();
        System.out.println(s.isLongPressedName(name, typed));

    }
}
