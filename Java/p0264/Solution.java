package p0264;

import java.util.*;

public class Solution {

    public int nthUglyNumber(int n) {
        long res = 1;
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> queue = new PriorityQueue<>();

        queue.offer(1L);
        set.add(1L);

        for (int i = 0; i < n; i++) {
            res = queue.poll();
            int[] facs = new int[]{2, 3, 5};
            for (int f : facs) {
                long next = res * f;
                if (!set.contains(next)) {
                    set.add(next);
                    queue.offer(next);
                }
            }
        }

        return (int)res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.nthUglyNumber(1690));
    }
}
