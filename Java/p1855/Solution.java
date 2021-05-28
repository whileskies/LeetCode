package p1855;


public class Solution {
    // 二分
    public int maxDistance0(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int res = 0;
        for (int i = 0; i < m; i++) {
            res = Math.max(res, find(nums1[i], nums2, i, n - 1) - i);
        }

        return res;
    }

    private int find(int key, int[] nums, int l, int r) {
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] >= key)
                l = mid;
            else
                r = mid - 1;
        }

        return l;
    }


    // 双指针
    public int maxDistance(int[] nums1, int[] nums2) {
        int res = 0;
        int i = 0;
        for (int j = 0; j < nums2.length; j++) {
            while (i < nums1.length && nums1[i] > nums2[j])
                i++;
            if (i < nums1.length)
                res = Math.max(res, j - i);
        }

        return res;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = new int[]{5, 4};
        int[] nums2 = new int[]{3, 2};
        System.out.println(s.maxDistance(nums1, nums2));

    }
}
