package p0057;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[][] insert0(int[][] intervals, int[] newInterval) {
        List<int[]> mergedList = new ArrayList<>();
        boolean hasInserted = false;

        int i = 0;
        while (i < intervals.length || !hasInserted) {
            int[] cur;
            int[] pre = mergedList.size() == 0 ? null : mergedList.get(mergedList.size() - 1);
            if (!hasInserted && i < intervals.length && newInterval[0] <= intervals[i][0] ||
                i == intervals.length) {
                cur = newInterval;
                hasInserted = true;
            } else {
                cur = intervals[i++];
            }

            if (pre != null && pre[1] >= cur[0]) {
                pre[1] = Math.max(pre[1], cur[1]);
            } else {
                mergedList.add(new int[]{cur[0], cur[1]});
            }
        }

        return mergedList.toArray(new int[mergedList.size()][]);
    }


    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> mergedList = new ArrayList<>();
        int left = newInterval[0];
        int right = newInterval[1];
        boolean hasInserted = false;

        for (int[] interval : intervals) {
            if (interval[1] < left) {
                mergedList.add(interval);
            } else if (interval[0] > right) {
                if (!hasInserted) {
                    mergedList.add(new int[]{left, right});
                    hasInserted = true;
                }
                mergedList.add(interval);
            } else {
                left = Math.min(interval[0], left);
                right = Math.max(interval[1], right);
            }
        }

        if (!hasInserted) {
            mergedList.add(new int[]{left, right});
        }

        return mergedList.toArray(new int[mergedList.size()][]);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] intervals = new int[][]{
                {1, 5}
        };
        int[] newInterval = new int[]{2, 7};
        int[][] ret = s.insert(intervals, newInterval);
        for (int[] p : ret) {
            System.out.println(Arrays.toString(p));
        }
    }
}
