import java.math.BigInteger;

class Solution {
    BigInteger combination(int n, int r) {
        if (r < 0 || r > n) return BigInteger.ZERO;
        BigInteger res = BigInteger.ONE;
        for (int i = 1; i <= r; i++) {
            res = res.multiply(BigInteger.valueOf(n - r + i));
            res = res.divide(BigInteger.valueOf(i));
        }
        return res;
    }

    public long distributeCandies(int n, int k) {
        BigInteger total = BigInteger.ZERO;
        for (int i = 0; i <= 3; i++) {
            int sign = (i % 2 == 0) ? 1 : -1;
            int rem = n - i * (k + 1);
            if (rem < 0) break;

            BigInteger comb1 = combination(3, i);
            BigInteger comb2 = combination(rem + 3 - 1, 3 - 1);
            BigInteger term = comb1.multiply(comb2).multiply(BigInteger.valueOf(sign));
            total = total.add(term);
        }
        return total.longValue();
    }
}
