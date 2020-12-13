package p0008;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int myAtoi0(String str) {
        StringBuilder sb = new StringBuilder();

        boolean beginSpace = true;
        boolean hasSig = false;
        boolean isNeg = false;
        boolean start = false;

        for (int i = 0; i < str.length(); i++) {
            if (beginSpace && str.charAt(i) == ' ')
                continue;
            if (beginSpace && str.charAt(i) != ' ')
                beginSpace = false;

            if (!start && !hasSig && str.charAt(i) == '-') {
                isNeg = true;
                hasSig = true;
            } else if (!start && !hasSig && str.charAt(i) == '+') {
                hasSig = true;
            } else if (Character.isDigit(str.charAt(i))) {
                start = true;
                if (!(sb.length() == 0 && str.charAt(i) == '0'))
                    sb.append(str.charAt(i));
            } else {
                break;
            }
        }

        if (sb.length() == 0)
            return 0;

        int ret = 0;

        if (sb.length() > 10)
            return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        for (int i = 0; i < sb.length(); i++) {
            int d = sb.charAt(i) - '0';
            if (!isNeg && i == sb.length() - 1 && (ret > Integer.MAX_VALUE / 10 || ret == Integer.MAX_VALUE / 10 && d > 7))
                return Integer.MAX_VALUE;
            if (isNeg && i == sb.length() - 1 && (ret > Integer.MAX_VALUE / 10 ||  ret == Integer.MAX_VALUE / 10 && d >= 8))
                return Integer.MIN_VALUE;
            ret = ret * 10 + d;
        }

        return isNeg ? -ret : ret;
    }


    public int myAtoi(String str) {
        Automation automation = new Automation();
        for (int i = 0; i < str.length(); i++) {
            automation.get(str.charAt(i));
        }

        return (int)(automation.sign * automation.ans);
    }

    static class Automation {
        public int sign = 1;
        public long ans = 0;
        private String state = "start";
        private final Map<String, String[]> table = new HashMap<>() {{
            put("start", new String[]{"start", "signed", "in_number", "end"});
            put("signed", new String[]{"end", "end", "in_number", "end"});
            put("in_number", new String[]{"end", "end", "in_number", "end"});
            put("end", new String[]{"end", "end", "end", "end"});
        }};

        public void get(char c) {
            state = table.get(state)[getCol(c)];
            if ("in_number".equals(state)) {
                ans = ans * 10 + (c - '0');
                ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
            } else if ("signed".equals(state)) {
                sign = c == '+' ? 1 : -1;
            }
        }

        private int getCol(char c) {
            if (c == ' ')
                return 0;
            if (c == '+' || c == '-')
                return 1;
            if (Character.isDigit(c))
                return 2;
            return 3;
        }
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        Solution s = new Solution();
        System.out.println(s.myAtoi("42") + " " + 42);
        System.out.println(s.myAtoi("   -42") + " " + -42);
        System.out.println(s.myAtoi("4193 with words") + " " + 4193);
        System.out.println(s.myAtoi("words and 987") + " " + 0);
        System.out.println(s.myAtoi("-91283472332") + " " + -2147483648);
        System.out.println(s.myAtoi(".1") + " " + 0);
        System.out.println(s.myAtoi("-12w34 23 w") + " " + -12);
        System.out.println(s.myAtoi("-12 23 w") + " " + -12);
        System.out.println(s.myAtoi("+-12") + " " + 0);
        System.out.println(s.myAtoi("12345678") + " " + 12345678);
        System.out.println(s.myAtoi("00000-42a1234") + " " + 0);
        System.out.println(s.myAtoi("21474836460") + " " + 2147483647);
        System.out.println(s.myAtoi("2147483800") + " " + 2147483647);
    }

}
