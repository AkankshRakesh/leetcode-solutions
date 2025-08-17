#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    long long maxProfit(vector<int>& prices, vector<int>& strategy, int k) {
        int n = prices.size();
        long long original = 0;
        for (int i = 0; i < n; i++)
            original += (long long) prices[i] * strategy[i];

        vector<long long> buyToHold(n + 1, 0);
        vector<long long> holdToSell(n + 1, 0);

        for (int i = 0; i < n; i++) {
            buyToHold[i + 1] = buyToHold[i] - (long long) strategy[i] * prices[i];
            holdToSell[i + 1] = holdToSell[i] + ((long long) 1 - strategy[i]) * prices[i];
        }

        long long maxGain = 0;

        for (int start = 0; start <= n - k; start++) {
            int mid = start + k / 2;
            int end = start + k;

            long long gain = (buyToHold[mid] - buyToHold[start]) + (holdToSell[end] - holdToSell[mid]);
            if (gain > maxGain)
                maxGain = gain;
        }

        return original + maxGain;
    }
};
