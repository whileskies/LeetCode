package contest.p5703;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                double gap1 = (double) (o1[0] + 1) / (o1[1] + 1) - (double) o1[0] / o1[1];
                double gap2 = (double) (o2[0] + 1) / (o2[1] + 1) - (double) o2[0] / o2[1];
                return Double.compare(gap1, gap2);
            }
        });

        queue.addAll(Arrays.asList(classes));

        for (int i = 0; i < extraStudents; i++) {
            int[] cls = queue.poll();
            cls[0]++;
            cls[1]++;
            queue.add(cls);
        }

        double avg = 0;
        for (int i = 0; i < classes.length; i++) {
            avg += (double) classes[i][0] / classes[i][1];
        }

        avg /= classes.length;

        return avg;
    }



}
