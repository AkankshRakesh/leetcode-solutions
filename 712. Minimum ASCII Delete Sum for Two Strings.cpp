class Solution {
public:
    int dfs(vector<vector<int>>& dp, string& s1, string& s2, int i, int j) {
        if (i >= s1.length()) {
            int sum = 0;
            for (int k = j; k < s2.length(); k++)
                sum += (int)s2[k];
            return sum;
        }

        if (j >= s2.length()) {
            int sum = 0;
            for (int k = i; k < s1.length(); k++)
                sum += (int)s1[k];
            return sum;
        }

        if (dp[i][j] != -1) return dp[i][j];

        if (s1[i] == s2[j])
            return dp[i][j] = dfs(dp, s1, s2, i + 1, j + 1);

        int ascii1 = (int)s1[i];
        int ascii2 = (int)s2[j];

        int delete1 = ascii1 + dfs(dp, s1, s2, i + 1, j);
        int delete2 = ascii2 + dfs(dp, s1, s2, i, j + 1);

        return dp[i][j] = min(delete1, delete2);
    }

    int minimumDeleteSum(string s1, string s2) {
        vector<vector<int>> dp(s1.length(), vector<int>(s2.length(), -1));
        return dfs(dp, s1, s2, 0, 0);
    }
};
