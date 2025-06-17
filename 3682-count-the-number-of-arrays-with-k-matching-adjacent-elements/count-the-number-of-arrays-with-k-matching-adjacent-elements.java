class Solution {
    static final int MOD = 1_000_000_007;

    public int countGoodArrays(int n, int m, int k) {
        long[] fact = new long[n];
        long[] invFact = new long[n];
        fact[0] = 1;

        // Precompute factorials
        for (int i = 1; i < n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        // Compute inverse factorials
        invFact[n - 1] = modInverse(fact[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }

        // Compute C(n-1, k)
        long comb = fact[n - 1] * invFact[k] % MOD * invFact[n - 1 - k] % MOD;

        // Result = m * C(n-1, k) * (m-1)^(n-1-k)
        long pow = modPow(m - 1, n - 1 - k);
        long res = m * comb % MOD * pow % MOD;

        return (int) res;
    }

    long modPow(long base, long exp) {
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) result = result * base % MOD;
            base = base * base % MOD;
            exp >>= 1;
        }
        return result;
    }

    long modInverse(long x) {
        return modPow(x, MOD - 2); // Fermat’s Little Theorem
    }
}
