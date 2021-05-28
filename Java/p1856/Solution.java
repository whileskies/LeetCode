package p1856;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class Solution {
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        Deque<Integer> leftStack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!leftStack.isEmpty() && nums[i] <= nums[leftStack.peek()])
                leftStack.pop();
            if (leftStack.isEmpty())
                left[i] = -1;
            else left[i] = leftStack.peek();
            leftStack.push(i);
        }

        int[] right = new int[n];
        Deque<Integer> rightStack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!rightStack.isEmpty() && nums[i] <= nums[rightStack.peek()])
                rightStack.pop();
            if (rightStack.isEmpty())
                right[i] = n;
            else right[i] = rightStack.peek();
            rightStack.push(i);
        }

        long[] preSum = new long[n + 1];
        preSum[0] = 0;
        for (int i = 1; i <= n; i++) preSum[i] = preSum[i - 1] + nums[i - 1];

        long res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, nums[i] * (preSum[right[i]] - preSum[left[i] + 1]));
        }

        return (int)(res % 1000000007);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1,2,3,2};
        System.out.println(s.maxSumMinProduct(nums));
    }
}
