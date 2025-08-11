class Solution {
public:
    vector<int> productQueries(int n, vector<vector<int>>& queries) {
        int size = queries.size();
        vector<int> ans(size);
        vector<int> arr;
        int ind = 0;

        while (n != 0) {
            if ((n & 1) == 1) {
                arr.push_back(1 << ind); // 2^ind
            }
            ind++;
            n >>= 1;
        }

        const int MOD = 1'000'000'007;
        for (int i = 0; i < size; i++) {
            int lower = queries[i][0];
            int upper = queries[i][1];
            if (lower == upper) {
                ans[i] = arr[lower];
            } else {
                long long prod = 1;
                for (int j = lower; j <= upper; j++) {
                    prod = (prod * arr[j]) % MOD;
                }
                ans[i] = (int)prod;
            }
        }

        return ans;
    }
};
