package p0781;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numRabbits(int[] answers) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : answers) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (var entry : map.entrySet()) {
            int n = entry.getKey();
            int cnt = entry.getValue();
            int sum = (cnt + n) / (n + 1)  * (n + 1);

            //System.out.println("n:" + n + " cnt:" + cnt + " sum:" + sum);
            res += sum;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] answers = new int[]{0,3,2,0,3,3,4,2,4,3,2,4,4,3,0,1,3,4,4,3};
//        int[] answers = new int[]{10, 10, 10};
        System.out.println(s.numRabbits(answers));
    }
}
