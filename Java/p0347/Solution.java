package p0347;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int num : nums) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k)
                pq.poll();
        }

        int[] res = new int[k];
        int i = 0;
        while (!pq.isEmpty()) res[i++] = pq.poll().getKey();

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        System.out.println(Arrays.toString(s.topKFrequent(nums, 3)));
    }
}
