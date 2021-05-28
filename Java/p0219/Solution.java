package p0219;

import java.util.*;

public class Solution {
    public boolean containsNearbyDuplicate0(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (map.containsKey(n)) {
                if (i - map.get(n) <= k)
                    return true;
            }
            map.put(n, i);
        }

        return false;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                return true;
            set.add(nums[i]);
            if (set.size() > k)
                set.remove(nums[i - k]);
        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1,2,3,1,2,3};
        System.out.println(s.containsNearbyDuplicate(nums, 2));
    }
}
