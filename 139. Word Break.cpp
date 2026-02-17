class Solution {
public:
    bool dfs(const string& s, int index, const unordered_set<string>& words, vector<optional<bool>>& dp) {
        if (index == (int)s.length()) return true;
        if (dp[index].has_value()) return dp[index].value();

        bool res = false;
        string sb;
        for (int i = index; i < (int)s.length(); i++) {
            sb.push_back(s[i]);
            if (words.count(sb) > 0) {
                res = res || dfs(s, i + 1, words, dp);
            }
            if (res) break;
        }

        dp[index] = res;
        return res;
    }

    bool wordBreak(const string& s, const vector<string>& wordDict) {
        unordered_set<string> words(wordDict.begin(), wordDict.end());
        vector<optional<bool>> dp(s.length());
        return dfs(s, 0, words, dp);
    }
};