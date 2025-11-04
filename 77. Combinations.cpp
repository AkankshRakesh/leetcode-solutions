class Solution {
public:
    vector<vector<int>> ans;

    void backtrack(int n, int curr, vector<int>& currArr, int k) {
        if (currArr.size() == k) {
            ans.push_back(currArr);
            return;
        }

        for (int i = curr + 1; i <= n; i++) {
            currArr.push_back(i);
            backtrack(n, i, currArr, k);
            currArr.pop_back();
        }
    }

    vector<vector<int>> combine(int n, int k) {
        for (int i = 1; i <= n; i++) {
            vector<int> currArr = {i};
            backtrack(n, i, currArr, k);
        }
        return ans;
    }
};