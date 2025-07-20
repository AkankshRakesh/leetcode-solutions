class Solution {
    static const int MOD = 1'000'000'007;

public:
    long long modInv(long long n, int mod) {
        return powmod(n, mod - 2, mod);
    }

    long long powmod(long long base, long long exp, int mod) {
        long long result = 1;
        base %= mod;
        while (exp > 0) {
            if (exp & 1) result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

    int countTrapezoids(vector<vector<int>>& points) {
        unordered_map<int, vector<int>> yMap;

        for (const auto& point : points) {
            int x = point[0];
            int y = point[1];
            yMap[y].push_back(x);
        }

        long long total = 0;
        long long sumPoints = 0;

        for (auto& [y, xList] : yMap) {
            int n = xList.size();
            if (n >= 2) {
                long long combinations = (1LL * n * (n - 1)) / 2;
                total = (total + combinations) % MOD;
                sumPoints = (sumPoints + (combinations * combinations) % MOD) % MOD;
            }
        }

        long long result = ((total * total) % MOD - sumPoints + MOD) % MOD;
        result = (result * modInv(2, MOD)) % MOD;

        return static_cast<int>(result);
    }
};
