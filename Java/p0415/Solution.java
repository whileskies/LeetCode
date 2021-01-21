package p0415;

public class Solution {
    private int toInt(char ch) {
        return ch - '0';
    }

    public String addStrings(String num1, String num2) {
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

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.addStrings("123", "456"));
    }
}
