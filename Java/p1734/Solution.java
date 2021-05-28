package p1734;

import java.util.Arrays;

public class Solution {
    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int[] perm = new int[n];

        int r = 0;
        for (int i = 1; i <= n; i++)
            r ^= i;
        int l = 0;
        for (int i = 1; i < n - 1; i += 2)
            l ^= encoded[i];
        perm[0] = l ^ r;

        for (int i = 1; i < n; i++) {
            perm[i] = perm[i - 1] ^ encoded[i - 1];
        }

        return perm;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] encoded = new int[]{6, 5, 4, 6};
        System.out.println(Arrays.toString(s.decode(encoded)));
    }
}
