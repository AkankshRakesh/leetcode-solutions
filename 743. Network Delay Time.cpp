class Solution {
public:
    struct Pair {
        int x, y;
        Pair(int _x, int _y) : x(_x), y(_y) {}
    };

    void dfs(unordered_map<int, vector<Pair>>& hm, int n, int ele, int eleCost, vector<int>& minCosts, int currCost) {
        currCost += eleCost;
        minCosts[ele] = min(minCosts[ele], currCost);

        if (hm.count(ele)) {
            for (auto& pair : hm[ele]) {
                if (currCost + pair.y < minCosts[pair.x]) {
                    dfs(hm, n, pair.x, pair.y, minCosts, currCost);
                }
            }
        }

        currCost -= eleCost; // Optional in C++, as currCost is passed by value
    }

    int networkDelayTime(vector<vector<int>>& times, int n, int k) {
        vector<int> minCosts(n + 1, INT_MAX);
        unordered_map<int, vector<Pair>> hm;

        for (auto& time : times) {
            int u = time[0], v = time[1], cost = time[2];
            hm[u].emplace_back(v, cost);
        }

        dfs(hm, n, k, 0, minCosts, 0);

        int maxNum = INT_MIN;
        for (int i = 1; i <= n; ++i) {
            maxNum = max(maxNum, minCosts[i]);
        }

        return maxNum == INT_MAX ? -1 : maxNum;
    }
};
