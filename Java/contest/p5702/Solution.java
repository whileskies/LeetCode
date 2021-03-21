package contest.p5702;

import java.util.Arrays;

public class Solution {
    public int findCenter(int[][] edges) {
        int MAX = 100010;
        int[] map = new int[MAX];
        Arrays.fill(map, 0);

        for (int[] e : edges) {
            for (int i : e) {
                map[i]++;
            }
        }

        int max = -1;
        int res = 0;
        for (int i = 1; i < map.length; i++) {
            if (map[i] > max) {
                max = map[i];
                res = i;
            }
        }

        return res;
    }
}
