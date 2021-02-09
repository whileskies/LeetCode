package p0058;

public class Solution {
    public int lengthOfLastWord0(String s) {
        String[] words = s.split(" ");
        if (words.length == 0) {
            return 0;
        }

        return words[words.length - 1].length();
    }

    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') { i--; }
        if (i == -1) return 0;

        int cnt = 0;
        while (i >= 0 && s.charAt(i--) != ' ') {
            cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLastWord(" hello "));
    }
}
