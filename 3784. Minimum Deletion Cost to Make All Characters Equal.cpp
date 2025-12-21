class Solution {
public:
    long long minCost(string s, vector<int>& cost) {
        unordered_map<char, long long> hm;
        long long totalCost = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s[i];
            hm[ch] = hm.count(ch) ? hm[ch] + cost[i] : cost[i];
            totalCost += cost[i];
        }

        long long maxCost = 0;
        for (auto& ele : hm) {
            maxCost = max(maxCost, ele.second);
        }

        return totalCost - maxCost;
    }
};
