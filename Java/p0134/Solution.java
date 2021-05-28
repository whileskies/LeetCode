package p0134;

public class Solution {
    public int canCompleteCircuit0(int[] gas, int[] cost) {
        int n = gas.length;
        int sum;
        for (int i = 0; i < n; i++) {
            sum = gas[i];
            for (int j = (i + 1) % n, k = 0; k < n; j = (j + 1) % n, k++) {
                sum -= cost[(j - 1 + n) % n];
                if (sum < 0) break;
                sum += gas[j];
            }

            if (sum >= 0)
                return i;
        }

        return -1;
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0, j; i < n;) {
            int left = 0;
            for (j = 0; j < n; j++) {
                int k = (i + j) % n;
                left += gas[k];
                left -= cost[k];
                if (left < 0) break;
            }
            if (j == n) return i;
            else i = i + j + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] gas = new int[]{2,3,4};
        int[] cost = new int[]{3,4,3};
        System.out.println(s.canCompleteCircuit(gas, cost));
    }
}
