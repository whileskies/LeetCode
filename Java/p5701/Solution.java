package p5701;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean areAlmostEqual0(String s1, String s2) {
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

    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;
        List<Integer> diff = new ArrayList<>();

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff.add(i);
                if (diff.size() > 2)
                    return false;
            }
        }

        if (diff.size() == 0)
            return true;
        if (diff.size() == 1)
            return false;

        return s1.charAt(diff.get(0)) == s2.charAt(diff.get(1)) &&
                s1.charAt(diff.get(1)) == s2.charAt(diff.get(0));
    }
}
