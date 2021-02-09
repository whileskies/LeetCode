package p0048;

import java.util.Arrays;

public class Solution {
    //n^2旋转
    public void rotate0(int[][] matrix) {
        int n = matrix.length;
        int[][] newMatrix = new int[n][n];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                newMatrix[c][n - r - 1] = matrix[r][c];
            }
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                matrix[r][c] = newMatrix[r][c];
            }
        }
    }


    //原地旋转
    public void rotate1(int[][] matrix) {
        int n = matrix.length;
        for (int r = 0; r < n / 2; r++) {
            for (int c = 0; c < (n + 1) / 2; c++) {
                int tmp = matrix[r][c];
                matrix[r][c] = matrix[n - c - 1][r];
                matrix[n - c - 1][r] = matrix[n - r - 1][n - c - 1];
                matrix[n - r - 1][n - c - 1] = matrix[c][n - r - 1];
                matrix[c][n - r - 1] = tmp;
            }
        }

    }


    //水平+对角线翻转
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int r = 0; r < n / 2; r++) {
            for (int c = 0; c < n; c++) {
                int tmp = matrix[r][c];
                matrix[r][c] = matrix[n - r - 1][c];
                matrix[n - r - 1][c] = tmp;
            }
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < r; c++) {
                int tmp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        s.rotate(matrix);


        for (int r = 0; r < matrix.length; r++) {
            System.out.println(Arrays.toString(matrix[r]));
        }
    }
}
