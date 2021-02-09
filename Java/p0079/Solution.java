package p0079;

public class Solution {
    private boolean ans;

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0)
            return false;
        int m = board.length, n = board[0].length;
        boolean[][] vis = new boolean[m][n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                vis[r][c] = true;
                dfs(board, r, c, vis, word, 0);
                vis[r][c] = false;
            }
        }

        return ans;
    }

    private void dfs(char[][] board, int r, int c, boolean[][] vis, String word, int index) {
        if (ans) return;
        int m = board.length, n = board[0].length;
        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        if (index >= word.length() || board[r][c] != word.charAt(index)) {
            return;
        }
        if (index == word.length() - 1) {
            ans = true;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextR = r + dir[i][0];
            int nextC = c + dir[i][1];
            if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && !vis[nextR][nextC]) {
                vis[nextR][nextC] = true;
                dfs(board, nextR, nextC, vis, word, index + 1);
                vis[nextR][nextC] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] board = new char[][]{
                {'a'}
        };

        System.out.println(s.exist(board, "a"));
    }
}
