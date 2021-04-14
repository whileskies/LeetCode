package p0070;

public class Solution {
    //dp
    public int climbStairs0(int n) {
        int a = 0, b = 1;
        int fib = 1;

        for (int i = 1; i <= n; i++) {
            fib = a + b;
            a = b;
            b = fib;
        }

        return fib;
    }

    //矩阵快速幂
    public int climbStairs(int n) {
        int[][] m = {{1, 1}, {1, 0}};
        int[][] ret = mat2Pow(m, n);

        return ret[0][0];
    }

    private int[][] matMul(int[][] a, int[][] b) {
        int m = a.length, n = a[0].length;
        int q = b[0].length;
        int[][] ans = new int[m][q];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < q; j++) {
                int sum = 0;
                for (int k = 0; k < n; k++) {
                    sum += a[i][k] * b[k][j];
                }
                ans[i][j] = sum;
            }
        }

        return ans;
    }

    private int[][] mat2Mul(int[][] a, int[][] b) {
        int[][] ret = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                ret[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }

        return ret;
    }

    private int[][] mat2Pow(int[][] mat, int n) {
        int[][] ret = new int[][]{{1, 0}, {0, 1}};
        int[][] a = mat;
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = mat2Mul(ret, a);
            }
            a = mat2Mul(a, a);
            n = n >> 1;
        }

        return ret;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.climbStairs(5));

    }
}
