class Solution {
    struct Pair {
        int num;
        int pow;
        Pair(int n, int p) : num(n), pow(p) {}
    };

    int backtrack(vector<int>& dp, int n) {
        if (n <= 1) return 0;

        int res;
        if (n % 2 == 0) res = n / 2;
        else res = n * 3 + 1;

        if (res < (int)dp.size() && dp[res] != -1) return dp[res];

        int val = 1 + backtrack(dp, res);
        if (res < (int)dp.size()) dp[res] = val;

        return val;
    }

public:
    int getKth(int lo, int hi, int k) {
        auto cmp = [](const Pair& a, const Pair& b) {
            if (a.pow != b.pow) return a.pow > b.pow;
            return a.num > b.num;
        };

        priority_queue<Pair, vector<Pair>, decltype(cmp)> pq(cmp);

        vector<int> dp(10001, -1);

        for (int i = lo; i <= hi; i++) {
            int steps = 0;
            long long n = i;
            while (n != 1) {
                if (n % 2 == 0) n /= 2;
                else n = n * 3 + 1;
                steps++;
            }


            pq.emplace(i, steps);
        }

        k--;
        while (k > 0 && !pq.empty()) {
            pq.pop();
            k--;
        }

        return pq.top().num;
    }
};
