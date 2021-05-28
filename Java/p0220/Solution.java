package p0220;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class Solution {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long l = set.ceiling((long)nums[i] - t);
            if (l != null && l <= (long)nums[i] + t) {
                return true;
            }
            set.add((long)nums[i]);
            if (set.size() > k) set.remove((long)nums[i - k]);
        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1, 3, 6, 2};
        System.out.println(s.containsNearbyAlmostDuplicate(nums, 1, 2));
    }
}
