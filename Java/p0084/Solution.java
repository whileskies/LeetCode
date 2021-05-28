package p0084;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Deque<Integer> ls = new ArrayDeque<>();
        Deque<Integer> rs = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!ls.isEmpty() && heights[i] <= heights[ls.peek()])
                ls.pop();
            left[i] = ls.isEmpty() ? -1 : ls.peek();
            ls.push(i);
        }

        for (int i = n - 1; i >= 0; i--) {
            while (!rs.isEmpty() && heights[i] <= heights[rs.peek()])
                rs.pop();
            right[i] = rs.isEmpty() ? n : rs.peek();
            rs.push(i);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, heights[i] * (right[i] - 1 - left[i]));
        }

        return res;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        System.out.println(s.largestRectangleArea(heights));
    }
}
