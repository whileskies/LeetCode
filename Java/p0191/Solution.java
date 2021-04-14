package p0191;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight0(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt += (n & 1);
            n >>>= 1;
        }

        return cnt;
    }

    public int hammingWeight1(int n) {
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0)
                cnt++;
        }
        return cnt;
    }

    public int hammingWeight(int n) {
        int cnt = 0;
        while (n != 0) {
            n &= n - 1;
            cnt++;
        }
        return cnt;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int n = Integer.parseUnsignedInt("11111111111111111111111111111101", 2);
        System.out.println(s.hammingWeight(n));
    }
}
