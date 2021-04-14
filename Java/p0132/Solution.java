package p0132;

import java.util.Arrays;

public class Solution {
    public int minCut(String s) {
        int n = s.length();
        s = " " + s;
        boolean[][] g = new boolean[n + 2][n + 2];
        for (int i = 1; i <= n + 1; i++)
            Arrays.fill(g[i], true);

        for (int i = n; i >= 1; i--) {
            for (int j = i; j <= n; j++) {
                g[i][j] = g[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }

        int[] f = new int[n + 1];
        f[0] = 0;
        for (int i = 1; i <= n; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) {
                if (g[j][i])
                    f[i] = Math.min(f[i], f[j - 1] + 1);
            }
        }

        return f[n] - 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minCut("ab"));
    }
}
