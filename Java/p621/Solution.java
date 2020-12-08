package p621;

import java.util.Arrays;

public class Solution {
    public int leastInterval1(char[] tasks, int n) {
        int[] taskTimes = new int[26];
        Arrays.fill(taskTimes, 0);

        for (char task : tasks) {
            taskTimes[task - 'A']++;
        }

        Arrays.sort(taskTimes);

        int maxTimes = taskTimes[25];
        int maxCount = 0;

        for (int time : taskTimes) {
            if (time == maxTimes)
                maxCount++;
        }

        return Math.max((maxTimes - 1) * (n + 1) + maxCount, tasks.length);
    }

    public int leastInterval(char[] tasks, int n) {
        int[] taskTimes = new int[26];
        Arrays.fill(taskTimes, 0);

        for (char task : tasks) {
            taskTimes[task - 'A']++;
        }

        int[] wait = new int[26];
        Arrays.fill(wait, 0);

        int total = 0;
        int finish = 0;

        while (finish < tasks.length) {
            int maxTask = -1;
            for (int i = 0; i < 26; i++) {
                if (taskTimes[i] > 0 && wait[i] == 0) {
                    if (maxTask == -1 || taskTimes[maxTask] < taskTimes[i]) {
                        maxTask = i;
                    }
                }
            }

            if (maxTask != -1) {
                taskTimes[maxTask]--;
                wait[maxTask] = n + 1;
                finish++;
            }

            for (int i = 0; i < 26; i++) {
                if (wait[i] != 0)
                    wait[i]--;
            }

            total++;
        }

        return total;
    }



    public static void main(String[] args) {
        Solution s = new Solution();
        char[] tasks = new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        System.out.println(s.leastInterval(tasks, 2));
    }
}
