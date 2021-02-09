package p0079;

public class Solution2 {

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0)
            return false;
        int m = board.length, n = board[0].length;
        boolean[][] vis = new boolean[m][n];

        boolean ret;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                ret = dfs(board, r, c, vis, word, 0);
                if (ret) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int r, int c, boolean[][] vis, String word, int index) {
        int m = board.length, n = board[0].length;
        boolean ret = false;

        if (board[r][c] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }

        vis[r][c] = true;

        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : dirs) {
            int nextR = r + dir[0];
            int nextC = c + dir[1];
            if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && !vis[nextR][nextC]) {
                ret = dfs(board, nextR, nextC, vis, word, index + 1);
                if (ret) {
                    break;
                }
            }
        }

        vis[r][c] = false;

        return ret;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        char[][] board = new char[][]{
                {'a'}
        };

        System.out.println(s.exist(board, "a"));
    }
}
