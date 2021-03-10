package p0503;

import java.util.*;

public class Solution {
    static class Pair {
        int index;
        int value;

        Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public int[] nextGreaterElements0(int[] nums) {
        int[] res = new int[nums.length];
        if (nums.length == 0)
            return res;
        int[] exNums = new int[2 * nums.length - 1];
        System.arraycopy(nums, 0, exNums, 0, nums.length);
        System.arraycopy(nums, 0, exNums, nums.length, nums.length - 1);

        Map<Integer, Integer> map = new HashMap<>();
        Deque<Pair> stack = new LinkedList<>();

        for (int i = 0; i < exNums.length; i++) {
            while (!stack.isEmpty() && exNums[i] > stack.peek().value) {
                Pair p = stack.pop();
                map.put(p.index, exNums[i]);
            }
            stack.push(new Pair(i, exNums[i]));
        }

        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            map.put(p.index, -1);
        }

        for (int i = 0; i < nums.length; i++) {
            res[i] = map.get(i);
        }

        return res;
    }


    //单调栈直接存索引
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < 2 * n - 1; i++) {
            while (!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1, 2, 1};
        int[] res = s.nextGreaterElements(nums);
        System.out.println(Arrays.toString(res));
    }
}
