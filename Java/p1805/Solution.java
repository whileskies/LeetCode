package p1805;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < word.length(); i++) {
            if (!Character.isDigit(word.charAt(i)))
                continue;

            StringBuilder sb = new StringBuilder();
            int j = i;
            while (j < word.length() && Character.isDigit(word.charAt(j))) {
                sb.append(word.charAt(j));
                j++;
            }
            i = j;

            int k = 0;
            while (k < sb.length() - 1 && sb.charAt(k) == '0') k++;
            set.add(sb.substring(k));
        }

        return set.size();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numDifferentIntegers("a1b01c001"));
    }
}
