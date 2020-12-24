package p0014;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        String str = strs[0];

        int i;
        for (i = 0; i < str.length(); i++) {
            if (!isCommonChar(strs, str.charAt(i), i)) {
                break;
            }
        }

        return str.substring(0, i);
    }

    private boolean isCommonChar(String[] strs, char c, int pos) {
        for (String str : strs) {
            if (str.length() <= pos || str.charAt(pos) != c)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] strs = new String[]{"", "b"};
        System.out.println(s.longestCommonPrefix(strs));
    }
}
