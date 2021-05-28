package p0461;

public class Solution {
    public int hammingDistance(int x, int y) {
        int dis = 0;
        for (int i = 0; i < 32; i++) {
            dis += (x & 1) ^ (y & 1);
            x >>= 1;
            y >>= 1;
        }

        return dis;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.hammingDistance(1, 4));
    }
}
