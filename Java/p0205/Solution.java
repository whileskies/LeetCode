package p0205;

import java.util.*;

public class Solution {
    public boolean isIsomorphic0(String s, String t) {
        return change(s).equals(change(t));
    }

    private String change(String s) {
        Map<Character, Character> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, (char) (map.size() + 'a'));
            }
            sb.append(map.get(c));
        }
        return sb.toString();
    }

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (s2t.containsKey(sChar) && s2t.get(sChar) != tChar || t2s.containsKey(tChar) && t2s.get(tChar) != sChar)
                return false;
            s2t.put(sChar, tChar);
            t2s.put(tChar, sChar);
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isIsomorphic("paper", "title"));
    }
}
