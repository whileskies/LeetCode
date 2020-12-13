package p0012;

public class Solution {
    public String intToRoman(int num) {
        StringBuilder ret = new StringBuilder();
        int[] value = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanChar = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < value.length; i++) {
            while (num >= value[i]) {
                num -= value[i];
                ret.append(romanChar[i]);
            }
        }

        return ret.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.intToRoman(3));
        System.out.println(s.intToRoman(4));
        System.out.println(s.intToRoman(9));
        System.out.println(s.intToRoman(58));
        System.out.println(s.intToRoman(1994));
    }
}
