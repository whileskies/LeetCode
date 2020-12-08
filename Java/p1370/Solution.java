package p1370;

import java.util.Arrays;

public class Solution {
    public String sortString(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a'] ++;
        }

        StringBuilder ret = new StringBuilder();
        while (ret.length() < s.length()) {
            for (int i = 0; i < count.length; i++) {
                if (count[i] > 0) {
                    ret.append((char)('a' + i));
                    count[i]--;
                }
            }

            for (int i = count.length - 1; i >= 0; i--) {
                if (count[i] > 0) {
                    ret.append((char)('a' + i));
                    count[i]--;
                }
            }
        }

        return ret.toString();
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.sortString("spo"));

    }
}
