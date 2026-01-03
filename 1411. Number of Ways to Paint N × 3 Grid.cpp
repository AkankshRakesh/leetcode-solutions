class Solution {
public:
    int numOfWays(int n) {
        long mod = 1000000007;

        long a = 6;
        long b = 6;

        for (int i = 2; i <= n; i++) {
            long newA = (3 * a + 2 * b) % mod;
            long newB = (2 * a + 2 * b) % mod;
            a = newA;
            b = newB;
        }

        return (int)((a + b) % mod);
    }
};