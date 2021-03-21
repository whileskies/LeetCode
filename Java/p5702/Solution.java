package p5702;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findCenter0(int[][] edges) {
        int[] map = new int[100010];
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


    public int findCenter(int[][] edges) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] edge : edges) {
            int a = map.getOrDefault(edge[0], 0) + 1;
            map.put(edge[0], a);
            if (a > 1) return edge[0];

            int b = map.getOrDefault(edge[1], 0) + 1;
            map.put(edge[1], b);
            if (b > 1) return edge[1];
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] edges = new int[][]{{1, 2}, {5, 1}, {1, 3}, {1, 4}};
        System.out.println(s.findCenter(edges));
    }
}
