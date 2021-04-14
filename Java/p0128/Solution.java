package p0128;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int longestConsecutive0(int[] nums) {
        Arrays.sort(nums);

        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            int j = i;
            int re = 0;
            while (j + 1 < nums.length) {
                if (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                    re++;
                    j++;
                } else if (j + 1 < nums.length && nums[j] + 1 == nums[j + 1]) {
                    j++;
                } else {
                    break;
                }
            }
//            System.out.println(i + " " + j + " " + re);
            maxLen = Math.max(maxLen, j - i + 1 - re);
            i = j;
        }

        return maxLen;
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        int res = 0;
        for (int i : set) {
            if (!set.contains(i - 1)) {
                int j = i;
                while (set.contains(j + 1)) j++;
                res = Math.max(res, j - i + 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{};
        Solution s = new Solution();
        System.out.println(s.longestConsecutive(nums));
    }
}
