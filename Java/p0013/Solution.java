package p0013;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public int romanToInt0(String s) {
        int[] value = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanChar = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        List<String> romanCharList = Arrays.asList(romanChar);

        int ret = 0;
        int cur = 0;
        while (cur < s.length()) {
            String sub;
            if (cur == s.length() - 1)
                sub = s.substring(cur, cur + 1);
            else
                sub = s.substring(cur, cur + 2);
            int index = romanCharList.indexOf(sub);
            if (index != -1) {
                ret += value[index];
                cur += 2;
            } else {
                sub = s.substring(cur, cur + 1);
                index = romanCharList.indexOf(sub);
                ret += value[index];
                cur += 1;
            }
        }

        return ret;
    }

    public int romanToInt(String s) {
        int ret = 0;
        int pre = getNum(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int cur = getNum(s.charAt(i));
            if (pre < cur) {
                ret -= pre;
            } else {
                ret += pre;
            }
            pre = cur;
        }
        ret += pre;

        return ret;
    }

    private int getNum(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.romanToInt("MCMXCIV"));
    }
}
