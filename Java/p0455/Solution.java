package p0455;

import java.util.Arrays;

public class Solution {
    public int findContentChildren0(int[] g, int[] s) {
        int cnt = 0;
        for (int i = 0; i < g.length; i++) {
            int min = findMinContent(g[i], s);
            if (min != -1) {
                cnt++;
                s[min] = -1;
            }
        }

        return cnt;
    }

    private int findMinContent(int g, int[] s) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < s.length; i++) {
            if (s[i] != -1 && s[i] >= g && s[i] < min) {
                min = s[i];
                index = i;
            }
        }

        return index;
    }


    public int findContentChildren(int[] g, int[] s) {
        int cnt = 0;
        Arrays.sort(g);
        Arrays.sort(s);

        int j = 0;
        for (int i = 0; i < g.length; i++) {
            while (j < s.length && s[j] < g[i]) { j++; }
            if (j == s.length) break;
            cnt++; j++;
        }

        return cnt;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] g = new int[]{1, 2};
        int[] s = new int[]{1, 2, 3};
        System.out.println(solution.findContentChildren(g, s));
    }
}
