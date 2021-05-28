package p1486;

public class Solution {
    public int xorOperation(int n, int start) {
        int res = start;

        for (int i = 1; i < n; i++) {
            res ^= (start + 2 * i);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.xorOperation(10, 5));
    }
}
