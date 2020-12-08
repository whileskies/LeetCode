package p52;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int totalNQueens(int n) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        for (int col = 0; col < n; col++) {
            dfs(n, 0, col, path, res);
        }

        return res.size();
    }

    private void dfs(int n, int row, int col, List<Integer> path, List<List<Integer>> res) {
        path.add(col);
        if (row + 1 == n) {
            res.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        for (int nextCol = 0; nextCol < n; nextCol++) {
            if (checkPosition(row + 1, nextCol, path)) {
                dfs(n, row + 1, nextCol, path, res);
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


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.totalNQueens(8));
    }

}
