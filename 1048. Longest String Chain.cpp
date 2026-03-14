class Solution {
public:
    bool check(const string& word1, const string& word2, int len1, int len2) {
        int i = 0, j = 0;
        bool found = false;
        while (i < len1 && j < len2) {
            if (word1[i] != word2[j]) {
                if (found) return false;
                found = true;
                i++;
            } else {
                i++;
                j++;
            }
        }
        return true;
    }

    int longestStrChain(vector<string>& words) {
        int n = words.size();
        sort(words.begin(), words.end(), [](const string& a, const string& b) {
            return a.length() < b.length();
        });
        vector<int> dp(n, 1);

        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                const string& word1 = words[i];
                const string& word2 = words[j];
                int len1 = word1.length();
                int len2 = word2.length();
                if (len2 + 1 == len1 && check(word1, word2, len1, len2)) {
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }
        }

        int ans = 1;
        for (int dpVal : dp) ans = max(ans, dpVal);

        return ans;
    }
};