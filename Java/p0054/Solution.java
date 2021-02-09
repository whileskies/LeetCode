package p0054;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder0(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ret;
        }
        int m = matrix.length, n = matrix[0].length;
        boolean[][] vis = new boolean[m][n];

        boolean jplus = true, iplus = false, jsub = false, isub = false;
        int i = 0, j = 0;

        for (int k = 0; k < m * n; k++) {
            ret.add(matrix[i][j]);
            vis[i][j] = true;

            if (jplus && (j == n - 1 || vis[i][j + 1])) {
                jplus = false; iplus = true;
            } else if (iplus && (i == m - 1 || vis[i + 1][j])) {
                iplus = false; jsub = true;
            } else if (jsub && (j == 0 || vis[i][j - 1])) {
                jsub = false; isub = true;
            } else if (isub && (i == 0 || vis[i - 1][j])) {
                isub = false; jplus = true;
            }

            if (jplus) j++;
            if (iplus) i++;
            if (jsub) j--;
            if (isub) i--;
        }

        return ret;
    }


    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return ret;

        int m = matrix.length, n = matrix[0].length;
        boolean[][] vis = new boolean[m][n];
        int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int i = 0, j = 0;
        int curDir = 0;

        for (int k = 0; k < m * n; k++) {
            ret.add(matrix[i][j]);
            vis[i][j] = true;

            int nextI = i + dir[curDir][0], nextJ = j + dir[curDir][1];
            if (nextI == -1 || nextI == m || nextJ == -1 || nextJ == n || vis[nextI][nextJ]) {
                curDir = (curDir + 1) % 4;
            }

            i = i + dir[curDir][0];
            j = j + dir[curDir][1];
        }

        return ret;
    }


    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return ret;

        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = n - 1, top = 0, bottom = m - 1;

        while (left <= right && top <= bottom) {
            for (int j = left; j <= right; j++) {
                ret.add(matrix[top][j]);
            }
            for (int i = top + 1; i <= bottom; i++) {
                ret.add(matrix[i][right]);
            }
            if (left < right && top < bottom) {
                for (int j = right - 1; j > left; j--) {
                    ret.add(matrix[bottom][j]);
                }
                for (int i = bottom; i > top; i--) {
                    ret.add(matrix[i][left]);
                }
            }

            left++; top++;
            right--; bottom--;
        }

        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        int[][] mp = new int[][]{
                {1, 2, 3}
        };
        System.out.println(s.spiralOrder(matrix));
    }
}
