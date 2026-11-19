class Solution {
public:
    void dfs(vector<int>& candidates, int index, vector<vector<int>>& ans,
             vector<int>& curr, int currSum, int target,
             unordered_set<string>& hs, string& sb) {
        if (currSum == target) {
            if (hs.count(sb)) return;

            ans.push_back(curr);
            hs.insert(sb);
            return;
        }

        if (index >= candidates.size() || currSum > target) return;

        curr.push_back(candidates[index]);
        int len = sb.length();
        sb += to_string(candidates[index]) + "#";

        dfs(candidates, index, ans, curr, currSum + candidates[index], target, hs, sb);
        dfs(candidates, index + 1, ans, curr, currSum + candidates[index], target, hs, sb);

        sb.erase(len);
        curr.pop_back();

        dfs(candidates, index + 1, ans, curr, currSum, target, hs, sb);
    }

    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());

        vector<vector<int>> ans;
        unordered_set<string> hs;
        vector<int> curr;
        string sb;

        dfs(candidates, 0, ans, curr, 0, target, hs, sb);

        return ans;
    }
};