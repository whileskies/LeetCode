package p0075;

import java.util.Arrays;
import java.util.Random;

public class Sort {
    public static void sort(int[] nums) {
        quickSortHelper(nums, 0, nums.length - 1);
    }

    private static void insertSort(int[] nums, int l, int r) {
        for (int i = l + 1; i <= r; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= l && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
    }

    private static void quickSortHelper(int[] nums, int l, int r) {
        int threshold = 1000;
        if (r - l + 1 > threshold) {
            int i = partition(nums, l, r);
            quickSortHelper(nums, l, i - 1);
            quickSortHelper(nums, i + 1, r);
        } else {
            insertSort(nums, l, r);
        }
    }

    private static int partition(int[] nums, int l, int r) {
        // [l, i] <= pivot
        // (i, j) > pivot
        // [r] == pivot

        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);

        return i + 1;
    }

    private static void swap(int[] nums, int i0, int i1) {
        int t = nums[i0];
        nums[i0] = nums[i1];
        nums[i1] = t;
    }

    public static void main(String[] args) {
        int n = 1000000;
//        int n = 1000;
        int[] nums = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            nums[i] = random.nextInt(1000);
        }
        long begin = System.currentTimeMillis();
        Sort.sort(nums);
//        Sort.insertSort(nums, 0, nums.length - 1);
//        Arrays.sort(nums);
        long end = System.currentTimeMillis();
        System.out.println(Arrays.toString(nums));
        System.out.println("time: " + (end - begin));
    }
}
