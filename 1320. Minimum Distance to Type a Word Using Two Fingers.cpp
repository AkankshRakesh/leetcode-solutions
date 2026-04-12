class Solution {
public:
    int dfs(const string& word, char c1, char c2, int index, int dp[26][26][1000]) {
        if (index >= (int)word.length()) return 0;
        if (dp[c1 - 'A'][c2 - 'A'][index] != -1) return dp[c1 - 'A'][c2 - 'A'][index];

        int c1X = (c1 - 'A') % 6;
        int c1Y = (c1 - 'A') / 6;
        int c2X = (c2 - 'A') % 6;
        int c2Y = (c2 - 'A') / 6;
        int targetX = (word[index] - 'A') % 6;
        int targetY = (word[index] - 'A') / 6;
        int cost1 = abs(targetX - c1X) + abs(targetY - c1Y);
        int cost2 = abs(targetX - c2X) + abs(targetY - c2Y);
        int fingerA = cost1 + dfs(word, word[index], c2, index + 1, dp);
        int fingerB = cost2 + dfs(word, c1, word[index], index + 1, dp);

        return dp[c1 - 'A'][c2 - 'A'][index] = min(fingerA, fingerB);
    }

    void emptyDP(int dp[26][26][1000], int length) {
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                fill(dp[i][j], dp[i][j] + length, -1);
            }
        }
    }

    int minimumDistance(const string& word) {
        int length = (int)word.length();
        int dp[26][26][1000];
        int countChar[26] = {0};

        for (char ch : word) countChar[ch - 'A']++;

        int ans = INT_MAX;
        for (int i = 0; i < 26; i++) {
            if (countChar[i] == 0) continue;
            for (int j = i + 1; j < 26; j++) {
                if (countChar[j] == 0) continue;
                emptyDP(dp, length);
                ans = min(ans, dfs(word, (char)(i + 'A'), (char)(j + 'A'), 0, dp));
            }
        }

        return ans;
    }
};

