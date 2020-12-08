package p0003;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring1(String s) {
        int maxLen = 0;
        Set<Character> subStr = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (!subStr.contains(s.charAt(i))) {
                subStr.add(s.charAt(i));
            } else {
                maxLen = Math.max(maxLen, subStr.size());
                i = i - subStr.size();
                subStr.clear();
            }
        }
        maxLen = Math.max(maxLen, subStr.size());

        return maxLen;
    }

    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int j = 0;
        Set<Character> subStr = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && !subStr.contains(s.charAt(j))) {
                subStr.add(s.charAt(j));
                j++;
            }

            maxLen = Math.max(maxLen, j - i);
            subStr.remove(s.charAt(i));
        }

        return maxLen;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("abba"));
    }
}
