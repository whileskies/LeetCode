package p0179;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String largestNumber(int[] nums) {
        List<String> numsStr = new ArrayList<>();
        for (int n : nums) {
            numsStr.add(Integer.toString(n));
        }

        numsStr.sort((s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        StringBuilder res = new StringBuilder();
        for (String s : numsStr) {
            res.append(s);
        }

        int i = 0;
        while (i < res.length() - 1 && res.charAt(i) == '0') i++;

        return res.substring(i);
    }

    private int cmpNum(String s1, String s2) {
        if (s1.length() > s2.length())
            return 1;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i))
                continue;
            if (s1.charAt(i) > s2.charAt(i))
                return 1;
            else
                return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{0, 0};
        System.out.println(s.largestNumber(nums));
    }
}
