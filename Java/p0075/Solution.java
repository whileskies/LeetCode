package p0075;

import java.util.Arrays;

public class Solution {
    public void sortColors0(int[] nums) {
        int[] counter = new int[3];

        for (int num : nums) {
            counter[num]++;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (counter[j] > 0) {
                    nums[i] = j;
                    counter[j]--;
                    break;
                }
            }
        }
    }

    private void swap(int[] nums, int i0, int i1) {
        int t = nums[i0];
        nums[i0] = nums[i1];
        nums[i1] = t;
    }

    //单指针 两次遍历
    public void sortColors1(int[] nums) {
        int head = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, head, i);
                head++;
            }
        }

        for (int i = head; i < nums.length; i++) {
            if (nums[i] == 1) {
                swap(nums, head, i);
                head++;
            }
        }
    }

    //循环不变量
    public void sortColors(int[] nums) {
        //[0,p0) == 0, [p0,i) == 1, (p2,len-1) == 2
        int n = nums.length;
        int i = 0, p0 = 0, p2 = n - 1;

        while (i <= p2) {
            if (nums[i] == 0) {
                swap(nums, p0, i);
                p0++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, p2, i);
                p2--;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{2, 0, 1, 1, 0};
        s.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
