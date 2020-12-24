package p0387;

import java.util.Arrays;

public class Solution {
    public int firstUniqChar0(String s) {
        int[] cnt = new int[26];
        int[] pos = new int[26];
        Arrays.fill(cnt, 0);
        Arrays.fill(pos, 0);

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            cnt[index] ++;
            if (pos[index] == 0) {
                pos[index] = i;
            }
        }

        int ret = -1;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == 1 && (pos[i] < ret || ret == -1)) {
                ret = pos[i];
            }
        }

        return ret;
    }

    public int firstUniqChar(String s) {
        int[] cnt = new int[26];
        Arrays.fill(cnt, 0);

        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a'] ++;
        }

        int ret = -1;
        for (int i = 0; i < s.length(); i++) {
            if (cnt[s.charAt(i) - 'a'] == 1) {
                ret = i;
                break;
            }
        }

        return ret;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.firstUniqChar("loveleetcode"));
    }
}
