package p0067;

public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1, j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int ai = i >= 0 ? (a.charAt(i) - '0') : 0;
            int bj = j >= 0 ? (b.charAt(j) - '0') : 0;
            int sum = ai + bj + carry;
            sb.append(sum % 2);
            carry = sum >> 1;
            i--; j--;
        }

        sb.reverse();

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.addBinary("1010", "1011"));
    }
}
