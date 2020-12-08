package p6;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String convert2(String s, int numRows) {
        int n = s.length();
        List<List<Integer>> rows = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            rows.add(new ArrayList<>());
        }

        int cur = 0;
        while (cur < n) {
            for (int i = 0; i < numRows; i++) {
                rows.get(i).add(cur++);
            }
            for (int i = 0; i < numRows - 2; i++) {
                rows.get(numRows - 1 - i - 1).add(cur++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (List<Integer> row : rows) {
            for (int i : row) {
                if (i < n) {
                    sb.append(s.charAt(i));
                }
            }
        }

        return sb.toString();
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goDown = false;
        for (int i = 0; i < s.length(); i++) {
            rows.get(curRow).append(s.charAt(i));
            if (curRow == 0 || curRow == numRows - 1)
                goDown = !goDown;
            curRow += goDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder sb : rows) {
            ret.append(sb);
        }

        return ret.toString();
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.convert("AB", 1));

    }
}
