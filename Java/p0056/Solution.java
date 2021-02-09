package p0056;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

        List<int[]> retList = new ArrayList<>();

        int[] pre = new int[2];
        pre[0] = intervals[0][0]; pre[1] = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            if (pre[1] >= cur[0]) {
                pre[1] = Math.max(pre[1], cur[1]);
            } else {
                retList.add(pre);
                pre = new int[2];
                pre[0] = cur[0];
                pre[1] = cur[1];
            }
        }

        retList.add(pre);

        return retList.toArray(new int[retList.size()][]);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] intervals = new int[][] {
                {1, 4}, {2, 3}
        };
        int[][] ret = s.merge(intervals);
        for (int[] p : ret) {
            System.out.println(Arrays.toString(p));
        }
    }
}
