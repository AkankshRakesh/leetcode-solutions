#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int xorAfterQueries(vector<int>& nums, vector<vector<int>>& queries) {
        int n = nums.size();
        const int MOD = 1'000'000'007;

        for (auto& q : queries) {
            int l = q[0];
            int r = q[1];
            int k = q[2];
            int v = q[3];

            for (int i = l; i <= r; i += k) {
                nums[i] = (long (nums[i]) * v) % MOD;
            }
        }

        int xorSum = 0;
        for (int num : nums) xorSum ^= num;

        return xorSum;
    }
};
