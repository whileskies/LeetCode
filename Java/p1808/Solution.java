package p1808;

public class Solution {
    private final int MOD = 1000000007;

    private long quickPow(long a, long b) {
        long res = 1;
        while (b != 0) {
            if ((b & 1) == 1)
                res = (res * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }

        return res % MOD;
    }

    public int maxNiceDivisors(int primeFactors) {
        if (primeFactors <= 3) return primeFactors;
        if (primeFactors % 3 == 0)
            return (int) (quickPow(3, primeFactors / 3));
        if (primeFactors % 3 == 1)
            return (int) (quickPow(3, (primeFactors - 4) / 3) * 4 % MOD);
        return (int) (quickPow(3, (primeFactors - 2) / 3) * 2 % MOD);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxNiceDivisors(88));
    }
}
