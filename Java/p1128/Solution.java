package p1128;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    //time out
    public int numEquivDominoPairs0(int[][] dominoes) {
        int cnt = 0;
        int n = dominoes.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (dominoes[i][0] == dominoes[j][0] && dominoes[i][1] == dominoes[j][1] ||
                        dominoes[i][0] == dominoes[j][1] && dominoes[i][1] == dominoes[j][0]) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    //map
    public int numEquivDominoPairs1(int[][] dominoes) {
        int cnt = 0;
        Map<String, Integer> map = new HashMap<>();

        for (int[] dominoe : dominoes) {
            int a = dominoe[0];
            int b = dominoe[1];
            String key = a < b ? a + "-" + b : b + "-" + a;
            int curCnt = map.getOrDefault(key, 0);
            curCnt++;
            map.put(key, curCnt);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            cnt += combineNum(entry.getValue());
        }

        return cnt;
    }

    private int combineNum(int n) {
        return (n * (n - 1)) / 2;
    }

    //状态压缩
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] freq = new int[100];
        int cnt = 0;

        for (int[] domino : dominoes) {
            int a = domino[0];
            int b = domino[1];
            int num = a < b ? 10 * a + b : 10 * b + a;
            cnt += freq[num];
            freq[num]++;
        }

        return cnt;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] dominoes = new int[][]{
                {1, 2}, {2, 1}, {2, 1}, {1, 2}
        };
        System.out.println(s.numEquivDominoPairs(dominoes));

    }
}
