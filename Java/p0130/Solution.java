package p0130;

import java.util.Arrays;

public class Solution {
    private final int[] dx = new int[] {-1, 0, 1, 0};
    private final int[] dy = new int[] {0, 1, 0, -1};
    private int m;
    private int n;
    private char[][] board;

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        this.board = board;

        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O')
                dfs(0, i);
            if (board[m - 1][i] == 'O')
                dfs(m - 1, i);
        }

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O')
                dfs(i, 0);
            if (board[i][n - 1] == 'O')
                dfs(i, n - 1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'M')
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
            }
        }
    }

    private void dfs(int x, int y) {
        board[x][y] = 'M';
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == 'O')
                dfs(nx, ny);
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] board = new char[][]{
                {'O', 'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'X', 'O'},
                {'X', 'O', 'X', 'O', 'X'},
                {'O', 'X', 'O', 'O', 'O'},
                {'X', 'X', 'O', 'X', 'O'}
        };

        char[][] board2 = new char[][] {{'X'}};

        s.solve(board);

        for (var chs : board) {
            System.out.println(Arrays.toString(chs));
        }
    }

}
