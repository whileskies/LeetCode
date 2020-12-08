package p0925;

public class Solution2 {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++; j++;
            } else if (j > 0 && typed.charAt(j - 1) == typed.charAt(j)) {
                j++;
            } else {
                return false;
            }
        }

        return i == name.length();
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().isLongPressedName("leelee", "lleeelee"));
    }
}
