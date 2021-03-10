package p0496;

import java.util.*;

public class Solution {
    public int[] nextGreaterElement0(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            int j = i + 1;
            while (j < nums2.length && nums2[j] <= nums2[i]) j++;
            if (j < nums2.length)
                map.put(nums2[i], nums2[j]);
            else
                map.put(nums2[i], -1);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }

        return res;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }

        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = new int[]{4, 1, 2};
        int[] nums2 = new int[]{1, 3, 4, 2};
        int[] res = s.nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(res));
    }
}
