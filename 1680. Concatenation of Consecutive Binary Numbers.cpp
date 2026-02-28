class Solution {
public:
    int concatenatedBinary(int n) {
        long long res = 1;
        int MOD = 1'000'000'007;
        int bits = 1;
        for (int i = 2; i <= n; i++) {
            if ((i & (i - 1)) == 0) bits++;
            res = (res << bits) % MOD;
            res = (res + i) % MOD;
        }
        return static_cast<int>(res);
    }
};