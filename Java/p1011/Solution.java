package p1011;

public class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int weightsSum = 0;
        for (int n : weights) {
            weightsSum += n;
        }

        int l = 0, r = (int)1e7;

        while (l < r) {
            int mid = l + r >> 1;
            if (check(weights, D, mid, weightsSum)) // <= mid
                r = mid;
            else
                l = mid + 1;
        }

        return l;
    }

    private boolean check(int[] weights, int D, int cap, int weightsSum) {
        int i, j = 0;
        int sum = 0;
        for (i = 0; i < D; i++) {
            int dSum = 0;
            while (j < weights.length && dSum + weights[j] <= cap) {
                dSum += weights[j++];
            }
            sum += dSum;
            if (j == weights.length) break;
        }
        return sum == weightsSum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] weights = new int[]{1,2,3,1,1};
        System.out.println(s.shipWithinDays(weights, 4));
    }
}
