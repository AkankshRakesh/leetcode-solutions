class Solution {
public:
    int dfs(vector<vector<int>>& items, int index, int budget,
            vector<int>& divides, int canGetCopies,
            vector<vector<vector<int>>>& dp) {
        if (index >= items.size()) return 0;

        if (dp[index][budget][canGetCopies] != -1)
            return dp[index][budget][canGetCopies];

        int cost = items[index][1];
        int pick = INT_MIN;

        if (budget - cost >= 0) {
            pick = max(
                dfs(items, index, budget - cost, divides, 0, dp),
                dfs(items, index + 1, budget - cost, divides, 1, dp)
            ) + 1;

            if (canGetCopies == 1) pick += divides[index];
        }

        int notPick = dfs(items, index + 1, budget, divides, 1, dp);

        return dp[index][budget][canGetCopies] = max(pick, notPick);
    }

    int maximumSaleItems(vector<vector<int>>& items, int budget) {
        vector<int> divides(items.size());

        for (int i = 0; i < items.size(); i++) {
            int count = 0;

            for (int j = 0; j < items.size(); j++) {
                if (i == j) continue;

                if (items[j][0] % items[i][0] == 0)
                    count++;
            }

            divides[i] = count;
        }

        vector<vector<vector<int>>> dp(
            items.size(),
            vector<vector<int>>(budget + 1, vector<int>(2, -1))
        );

        return dfs(items, 0, budget, divides, 1, dp);
    }
};