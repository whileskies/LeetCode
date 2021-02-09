package p0059;

import java.util.Arrays;

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int curDir = 0;
        int row = 0, col = 0;
        for (int i = 1; i <= n * n; i++) {
            ret[row][col] = i;
            int nextRow = row + dir[curDir][0];
            int nextCol = col + dir[curDir][1];
            if (nextRow >= n || nextRow < 0 || nextCol >= n || nextCol < 0 || ret[nextRow][nextCol] != 0) {
                curDir = (curDir + 1) % 4;
            }

            row = row + dir[curDir][0];
            col = col + dir[curDir][1];
        }

        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] ret = s.generateMatrix(10);

        for (int[] r : ret) {
            System.out.println(Arrays.toString(r));
        }
    }
}
