package p0137;

public class Solution {
    public int singleNumber0(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int n : nums) {
                sum += (n >> i & 1);
            }

            if (sum % 3 == 1)
                ans |= 1 << i;
        }

        return ans;
    }

    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int n : nums) {
            b = ~a & (b ^ n);
            a = ~b & (a ^ n);
        }

        return b;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{0,1,0,1,0,1,Integer.MAX_VALUE};
        System.out.println(s.singleNumber(nums));
    }
}
