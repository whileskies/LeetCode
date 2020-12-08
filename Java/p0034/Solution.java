package p0034;

import java.util.Arrays;

public class Solution {
    public int[] searchRange1(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int begin = 0, end = r;

        while (l <= r) {
            int m = (l + r) / 2;

            if (nums[m] == target) {
                int i = m - 1;
                while (i >= 0 && nums[i] == target) { i--; };
                begin = i + 1;

                i = m + 1;
                while (i < nums.length && nums[i] == target) { i++; };
                end = i - 1;

                return new int[]{begin, end};
            } else if (nums[m] < target)
                l = m + 1;
            else
                r = m - 1;
        }

        return new int[]{-1, -1};
    }

    public int[] searchRange(int[] nums, int target) {
        int[] ret = new int[]{-1, -1};

        int first = binarySearchFirst(nums, target);
        if (first == -1)
            return ret;
        ret[0] = first;

        int last = binarySearchLast(nums, target);
        ret[1] = last;

        return ret;
    }

    public int binarySearchFirst(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;

            if (nums[m] == target)
                r = m - 1;
            else if (nums[m] > target)
                r = m - 1;
            else
                l = m + 1;
        }

        if (l < nums.length && nums[l] == target)
            return l;
        else
            return -1;
    }

    public int binarySearchLast(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;

            if (nums[m] == target)
                l = m + 1;
            else if (nums[m] < target)
                l = m + 1;
            else
                r = m - 1;
        }

        if (r >= 0 && nums[r] == target)
            return r;
        else
            return -1;
    }


    public static void main(String[] args) {
        int[] nums = new int[] {5,7,7,8,8,10};
        System.out.println(Arrays.toString(new Solution().searchRange(nums, 6)));
    }
}
