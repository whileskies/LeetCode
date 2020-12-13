package p0649;

import java.util.Arrays;

public class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        int[] block = new int[n];
        Arrays.fill(block, 0);

        int cur = 0;
        while (true) {
            char party = senate.charAt(cur);
            if (block[cur] == 0) {
                if (party == 'R') {
                    int i = (cur + 1) % n;
                    while (i != cur) {
                        if (senate.charAt(i) == 'D' && block[i] == 0) {
                            block[i] = 1;
                            break;
                        }
                        i = (i + 1) % n;
                    }
                    if (i == cur)
                        return "Radiant";
                } else {
                    int j = (cur + 1) % n;
                    while (j != cur) {
                        if (senate.charAt(j) == 'R' && block[j] == 0) {
                            block[j] = 1;
                            break;
                        }
                        j = (j + 1) % n;
                    }
                    if (j == cur)
                        return "Dire";
                }
            }
            cur = (cur + 1) % n;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.predictPartyVictory("DDRRR"));
    }
}
