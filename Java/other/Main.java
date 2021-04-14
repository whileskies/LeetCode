package other;

public class Main {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        int end = nums.length - 1;
        while (end > 0 && nums[0] == nums[end]) end--;
        if (end == 0) return nums[0] == target;

        int l = 0, r = end;
        while (l < r) {
            int mid = l + r + 1>> 1;
            if (nums[mid] >= nums[0])
                l = mid;
            else
                r = mid - 1;
        }

        if (target >= nums[0]) l = 0;
        else {
            l++;
            r = end;
        }

        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= target)
                l = mid;
            else
                r = mid - 1;
        }

        return nums[r] == target;
    }


    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = new int[]{1, 3};
        System.out.println(main.search(nums, 0));
    }
}
