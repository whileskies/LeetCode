package p1482;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) return -1;
        int l = Arrays.stream(bloomDay).min().getAsInt();
        int r = Arrays.stream(bloomDay).max().getAsInt();

        while (l < r) {
            int mid = l + r >> 1;
            if (check(mid, bloomDay, m, k))
                r = mid;
            else
                l = mid + 1;
        }

        return l;
    }

    private boolean check(int day, int[] bloomDay, int m, int k) {
        int cnt = 0;
        int flower = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                flower++;
                if (flower == k) {
                    cnt++;
                    flower = 0;
                }
            } else {
                flower = 0;
            }
        }

        return cnt >= m;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] bloomDay = new int[]{1,10,2,9,3,8,4,7,5,6};
        System.out.println(s.minDays(bloomDay, 4, 4));
    }

}
