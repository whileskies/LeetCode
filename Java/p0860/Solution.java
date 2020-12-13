package p0860;

public class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;

        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0)
                    return false;
                ten++;
                five--;
            } else {
                //15
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] bills = new int[]{5,5,10,10,20};
        System.out.println(s.lemonadeChange(bills));

    }
}
