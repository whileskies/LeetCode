package p0043;

public class Solution {
    //第一次尝试
    private int toInt(char ch) {
        return ch - '0';
    }

    private String add(String num1, String num2) {
        StringBuilder ret = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry > 0) {
            int a = i >= 0 ? toInt(num1.charAt(i)) : 0;
            int b = j >= 0 ? toInt(num2.charAt(j)) : 0;
            int sum = a + b + carry;
            carry = sum / 10;
            ret.append(sum % 10);
            i--; j--;
        }

        return ret.reverse().toString();
    }

    private String aDigitMultiply(String n, char digit) {
        if (digit == '0') return "0";
        StringBuilder ret = new StringBuilder();
        int carry = 0;
        for (int i = n.length() - 1; i >= 0; i--) {
            int val = toInt(n.charAt(i)) * toInt(digit) + carry;
            carry = val / 10;
            ret.append(val % 10);
        }

        if (carry > 0)
            ret.append(carry);
        return ret.reverse().toString();
    }

    public String multiply0(String num1, String num2) {
        String ret = "0";

        for (int i = num2.length() - 1; i >= 0; i--) {
            StringBuilder mulRet = new StringBuilder(aDigitMultiply(num1, num2.charAt(i)));
            if (!mulRet.toString().equals("0")) {
                for (int j = 0; j < num2.length() - 1 - i; j++) {
                    mulRet.append('0');
                }
            }
            ret = add(ret, mulRet.toString());
        }

        return ret;
    }

    //直接乘
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        int m = num1.length(), n = num2.length();
        int[] retArr = new int[m + n];

        for (int i = n - 1; i >= 0; i--) {
            int x = num2.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int y = num1.charAt(j) - '0';
                retArr[i + j + 1] += x * y;
            }
        }

        for (int i = m + n - 1; i >= 1; i--) {
            retArr[i - 1] += retArr[i] / 10;
            retArr[i] %= 10;
        }

        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < m + n; i++) {
            if (i == 0 && retArr[i] == 0)
                continue;
            ret.append(retArr[i]);
        }

        return ret.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.multiply("1232313", "453236"));
    }
}
