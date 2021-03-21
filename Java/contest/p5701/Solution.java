package contest.p5701;

public class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            for (int j = i + 1; j < s1.length(); j++) {
                StringBuilder sb = new StringBuilder(s1);
                char t = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(j));
                sb.setCharAt(j, t);
                if (sb.toString().equals(s2))
                    return true;
            }
        }

        return false;
    }
}
