package p0066;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> retList = new ArrayList<>();

        int i = digits.length - 1;
        int carry = 1;
        while (i >= 0 || carry > 0) {
            int d = i >= 0 ? digits[i] : 0;
            int sum = d + carry;
            retList.add(sum % 10);
            carry = sum / 10;
            i--;
        }

        Collections.reverse(retList);

        return retList.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] digits = new int[]{0};
        int[] ret = s.plusOne(digits);
        System.out.println(Arrays.toString(ret));
    }
}
