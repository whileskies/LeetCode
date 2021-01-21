package p0038;

public class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";

        String str = countAndSay(n - 1);
        StringBuilder ret = new StringBuilder();

        int i = 0;
        while (i < str.length()) {
            int j = i + 1;
            while (j < str.length() && str.charAt(j) == str.charAt(j - 1)) j++;
            ret.append(j - i);
            ret.append(str.charAt(i));
            i = j;
        }

        return ret.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countAndSay(5));
    }
}
