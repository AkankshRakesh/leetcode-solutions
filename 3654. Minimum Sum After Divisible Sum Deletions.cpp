#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    long long minArraySum(vector<int>& nums, int k) {
        long long totalSum = 0;
        for(int num : nums) totalSum += num;

        long long dp = 0;
        unordered_map<int, long long> hm;
        hm[0] = 0;
        long long ps = 0;

        for(int num : nums){
            ps += num;
            dp += num;
            int mod = ps % k;
            if(hm.count(mod)){
                dp = min(dp, hm[mod]);
            }
            hm[mod] = min(hm.count(mod) ? hm[mod] : LLONG_MAX, dp);
        }

        return dp;
    }
};
