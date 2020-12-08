package p0051;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        for (int col = 0; col < n; col++) {
            dfs(n, 0, col, path, res);
        }

        return toStringSolve(res, n);
    }

    private void dfs(int n, int row, int col, List<Integer> path, List<List<Integer>> res) {
        path.add(col);
        if (row == n - 1) {
            res.add(new ArrayList<>(path));
        } else {
            for (int nextCol = 0; nextCol < n; nextCol++) {
                if (checkPosition(row + 1, nextCol, path)) {
                    dfs(n, row + 1, nextCol, path, res);
                }
            }
       }
        path.remove(path.size() - 1);
    }

    private boolean checkPosition(int row, int col, List<Integer> path) {
        for (int preRow = 0; preRow < path.size(); preRow++) {
            int preCol = path.get(preRow);
            if (preRow == row || preCol == col || Math.abs(row - preRow) == Math.abs(col - preCol))
                return false;
        }
        return true;
    }

    private List<List<String>> toStringSolve(List<List<Integer>> res, int n) {
        List<List<String>> stringSolves = new ArrayList<>();
        for (List<Integer> solve : res) {
            List<String> stringSolve = new ArrayList<>();
            for (int r = 0; r < n; r++) {
                StringBuilder sb = new StringBuilder();
                for (int c = 0; c < n; c++) {
                    if (c == solve.get(r))
                        sb.append('Q');
                    else
                        sb.append('.');
                }
                stringSolve.add(sb.toString());
            }
            stringSolves.add(stringSolve);
        }

        return stringSolves;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<String>> res = s.solveNQueens(4);

        System.out.println("size: " + res.size());
        for (List<String> list : res) {
            for (String str : list) {
                System.out.println(str);
            }
            System.out.println();
        }
    }



}
