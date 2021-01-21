package p0028;

import java.util.Map;

public class Solution {
    public int strStr0(String haystack, String needle) {
        for (int pos = 0; pos <= haystack.length() - needle.length(); pos++) {
            boolean same = true;
            for (int i = pos; i < pos + needle.length(); i++) {
                if (haystack.charAt(i) != needle.charAt(i - pos)) {
                    same = false;
                    break;
                }
            }
            if (same)
                return pos;
        }

        return -1;
    }

    public int strStr1(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;

        int i = 0, j = 0;
        int pos = -1;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (j == 0) pos = i;
                i++; j++;
            } else {
                if (j != 0) {
                    j = 0;
                    i = pos;
                    pos = -1;
                }
                i++;
            }
        }

        return j == needle.length() ? pos : -1;
    }

    public int charToInt(int idx, String s) {
        return (int) s.charAt(idx) - (int) 'a';
    }

    public int strStr(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();
        if (L > n) return -1;

        int a = 26;
        long modulus = (long) Math.pow(2, 31);

        long h = 0, needleHash = 0;
        for (int i = 0; i < L; i++) {
            h = (h * a + charToInt(i, haystack)) % modulus;
            needleHash = (needleHash * a + charToInt(i, needle)) % modulus;
        }
        if (h == needleHash) return 0;

        long aL = 1;
        for (int i = 1; i <= L; i++) aL = (aL * a) % modulus;

        for (int i = 1; i < n - L + 1; i++) {
            h = (h * a - charToInt(i - 1, haystack) * aL + charToInt(i + L - 1, haystack)) % modulus;
            if (h == needleHash)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.strStr("hello", "ll"));
    }
}
