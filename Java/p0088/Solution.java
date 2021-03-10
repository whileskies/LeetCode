package p0088;

import java.util.Arrays;

public class Solution {
    public void merge0(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = new int[m + n];
        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                tmp[k++] = nums1[i++];
            } else {
                tmp[k++] = nums2[j++];
            }
        }

        while (i < m) {
            tmp[k++] = nums1[i++];
        }

        while (j < n) {
            tmp[k++] = nums2[j++];
        }

        System.arraycopy(tmp, 0, nums1, 0, m + n);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = new int[] {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = new int[]{2, 5, 6};
        int n = 3;
        s.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));

    }
}
