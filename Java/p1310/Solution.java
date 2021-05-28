package p1310;

import java.util.Arrays;

public class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] res = new int[queries.length];
        int[] sum = new int[n + 1];

        sum[0] = 0;
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] ^ arr[i - 1];
        }

        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            res[i] = sum[q[1] + 1] ^ sum[q[0]];
        }

        return res;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{1, 3, 4, 8};
        int[][] queries = new int[][] {{0, 1}, {1, 2}, {0, 3}, {3, 3}};
        System.out.println(Arrays.toString(s.xorQueries(arr, queries)));
    }
}
