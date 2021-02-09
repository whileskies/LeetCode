package p0053;

public class Solution {
    public int maxSubArray0(int[] nums) {
        int ret = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum < num) {
                sum = num;
            }
            ret = Math.max(ret, sum);
        }

        return ret;
    }

    public int maxSubArray1(int[] nums) {
        int ret = nums[0];
        int sum = 0;
        for (int num : nums) {
            sum = Math.max(sum + num, num);
            ret = Math.max(ret, sum);
        }

        return ret;
    }


    //Divide and conquer
    static class Status {
        public int lSum, rSum, mSum, iSum;

        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }

    public Status getInfo(int[] nums, int l, int r) {
        if (l == r) {
            return new Status(nums[l], nums[l], nums[l], nums[l]);
        }

        int m = (l + r) >> 1;
        Status ls = getInfo(nums, l, m);
        Status rs = getInfo(nums, m + 1, r);

        return pushUp(ls, rs);
    }

    public Status pushUp(Status ls, Status rs) {
        int iSum = ls.iSum + rs.iSum;
        int lSum = Math.max(ls.lSum, ls.iSum + rs.lSum);
        int rSum = Math.max(rs.rSum, rs.iSum + ls.rSum);
        int mSum = Math.max(Math.max(ls.mSum, rs.mSum), ls.rSum + rs.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }

    public int maxSubArray(int[] nums) {
        return getInfo(nums, 0, nums.length - 1).mSum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{
                -2, 1, -3, 4, -1, 2, 1, -5, 4
        };

        System.out.println(s.maxSubArray(nums));
    }
}
