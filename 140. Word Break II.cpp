class Solution {
public:
    void dfs(const string& s, int index, const unordered_set<string>& words, string& currStr, vector<string>& curr) {
        if (index >= (int)s.length()) {
            curr.push_back(currStr);
            return;
        }

        string sb;

        for (int i = index; i < (int)s.length(); i++) {
            sb.push_back(s[i]);
            if (words.count(sb)) {
                string temp = currStr;
                if (i + 1 != (int)s.length()) currStr += sb + " ";
                else currStr += sb;

                dfs(s, i + 1, words, currStr, curr);
                currStr = temp;
            }
        }
    }

    vector<string> wordBreak(string s, vector<string>& wordDict) {
        vector<string> ans;
        unordered_set<string> hs(wordDict.begin(), wordDict.end());

        string currStr;
        dfs(s, 0, hs, currStr, ans);
        return ans;
    }
};