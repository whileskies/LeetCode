package p0557;

public class Solution {
    public String reverseWords1(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");

        for (int i = 0; i < words.length; i++) {
            sb.append(new StringBuilder(words[i]).reverse());
            if (i != words.length - 1) sb.append(' ');
        }

        return sb.toString();
    }

    public String reverseWords(String s) {
        StringBuilder ret = new StringBuilder();
        int start = 0, i = -1;
        int length = s.length();

        while (i < length) {
            while (++i < length && s.charAt(i) != ' ');

            if (start != 0) ret.append(' ');
            for (int j = i - 1; j >= start; j--)
                ret.append(s.charAt(j));
            i++;
            start = i;
        }

        return ret.toString();
    }




    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("Let's take LeetCode contest"));
    }
}
