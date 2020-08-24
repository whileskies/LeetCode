import java.util.Arrays;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[pos++] = nums[i];
            }
        }

        return pos;
    }

    public int removeElement2(int[] nums, int val) {
        int ans = nums.length;
        for (int i = 0; i < ans; ) {
            if (nums[i] == val) {
                nums[i] = nums[ans - 1];
                ans--;
            } else {
                i++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(new Solution().removeElement2(nums, 2));
        System.out.println(Arrays.toString(nums));
    }
}
