class Solution {
public:
    void backtrack(vector<string>& ans, string& curr, bool lastZero, int n) {
        if (curr.length() == n) {
            ans.push_back(curr);
            return;
        }

        if (!lastZero) {
            curr.push_back('0');
            backtrack(ans, curr, true, n);
            curr.pop_back();
        }

        curr.push_back('1');
        backtrack(ans, curr, false, n);
        curr.pop_back();
    }

    vector<string> validStrings(int n) {
        vector<string> ans;
        string curr;
        backtrack(ans, curr, false, n);
        return ans;
    }
};
