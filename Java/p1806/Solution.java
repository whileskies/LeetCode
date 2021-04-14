package p1806;

public class Solution {
    public int reinitializePermutation(int n) {
        int[] arr = new int[n];
        int[] perm = new int[n];

        for (int i = 0; i < n; i++) {
            perm[i] = i;
        }

        int cnt = 0;
        while (true) {
            cnt++;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0)
                    arr[i] = perm[i / 2];
                else
                    arr[i] = perm[n / 2 + (i - 1) / 2];
            }

            boolean done = true;
            for (int i = 0; i < n; i++) {
                if (arr[i] != i) {
                    done = false;
                    break;
                }
            }

            if (done) break;

            System.arraycopy(arr, 0, perm, 0, n);
        }

        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reinitializePermutation(1000));
    }
}
