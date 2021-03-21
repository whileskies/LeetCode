package p5703;

import java.util.Arrays;
import java.util.PriorityQueue;


public class Solution {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            double a = (double) (o1[0] + 1) / (o1[1] + 1) - (double) o1[0] / o1[1];
            double b = (double) (o2[0] + 1) / (o2[1] + 1) - (double) o2[0] / o2[1];
            return Double.compare(b, a);
        });

        queue.addAll(Arrays.asList(classes));

        for (int i = 0; i < extraStudents; i++) {
            int[] c = queue.poll();
            c[0]++; c[1]++;
            queue.add(c);
        }

        double avg = 0;
        for (int[] c : classes) {
            avg += (double) c[0] / c[1];
        }

        return avg / classes.length;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] classes = new int[][]{
                {1, 2}, {3, 5}, {2, 2}
        };
        System.out.println(s.maxAverageRatio(classes, 2));
    }



}
