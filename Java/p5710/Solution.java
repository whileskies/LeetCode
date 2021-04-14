package p5710;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> buyQueue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        PriorityQueue<int[]> sellQueue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);

        for (int[] order : orders) {
            if (order[2] == 0) {
                buyQueue.offer(order);
            } else {
                sellQueue.offer(order);
            }

            while (!buyQueue.isEmpty() && !sellQueue.isEmpty()) {
                int[] buy = buyQueue.poll();
                int[] sell = sellQueue.poll();

                if (buy[0] < sell[0]) {
                    buyQueue.offer(buy);
                    sellQueue.offer(sell);
                    break;
                }

                int min = Math.min(buy[1], sell[1]);
                buy[1] -= min;
                sell[1] -= min;

                if (buy[1] > 0)
                    buyQueue.offer(buy);
                if (sell[1] > 0)
                    sellQueue.offer(sell);
            }
        }

        long res = 0;
        int MOD = 1000000007;

        while (!buyQueue.isEmpty()) {
            int[] buy = buyQueue.poll();
            res = (res + buy[1]) % MOD;
        }

        while (!sellQueue.isEmpty()) {
            int[] sell = sellQueue.poll();
            res = (res + sell[1]) % MOD;
        }

        return (int)res % MOD;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] orders = new int[][]{{7,1000000000,1}, {15,3,0}, {5,999999995,0}, {5,1,1}};
        System.out.println(s.getNumberOfBacklogOrders(orders));

    }
}
