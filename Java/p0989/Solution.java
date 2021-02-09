package p0989;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    //逐位相加
    public List<Integer> addToArrayForm0(int[] A, int K) {
        List<Integer> ret = new ArrayList<>();
        int carry = 0;
        int i = A.length - 1;

        while (i >= 0 || K != 0 || carry > 0) {
            int a = i >= 0 ? A[i] : 0;
            int b = K > 0 ? K % 10 : 0;
            int sum =  a + b + carry;
            ret.add(sum % 10);
            carry = sum / 10;
            K /= 10;
            i--;
        }

        Collections.reverse(ret);
        return ret;
    }

    //加到最低位
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> ret = new ArrayList<>();
        int n = A.length;
        for (int i = n - 1; i >= 0 || K > 0; i--, K /= 10) {
            if (i >= 0) {
                K += A[i];
            }
            ret.add(K % 10);
        }

        Collections.reverse(ret);
        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] A = new int[]{9, 9};
        int K = 1;
        System.out.println(s.addToArrayForm(A, K));
    }
}
