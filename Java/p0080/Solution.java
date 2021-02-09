package p0080;

public class Solution {
    public int removeDuplicates0(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int pre = nums[0];
        int cnt = 1;
        int p = 0;

        for (int i = 1; i < nums.length; i++) {
            if (pre == nums[i]) {
                cnt++;
                if (cnt <= 2) {
                    nums[++p] = nums[i];
                }
            } else {
                cnt = 1;
                pre = nums[i];
                nums[++p] = nums[i];
            }
        }

        return p + 1;
    }

    public int removeDuplicates(int[] nums) {
        int p = 0;

        for (int i = 0; i < nums.length; i++) {
            if (p < 2 || nums[p - 2] != nums[i]) {
                nums[p++] = nums[i];
            }
        }

        return p;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{-1, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 4};
        int len = s.removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
