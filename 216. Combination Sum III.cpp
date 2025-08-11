class Solution {
public:
    void backtrack(vector<vector<int>>& ans, unordered_set<string>& seen,
                   int currEle, vector<int>& currArr, int currSum,
                   int sum, int count, int maxCount) {

        if (currSum > sum || count > maxCount) return;
        if (currEle > 9 || (currSum == sum && count == maxCount)) {
            if (currSum == sum && count == maxCount) {
                string key;
                for (int num : currArr) {
                    key += to_string(num) + ",";
                }
                if (seen.count(key)) return;
                seen.insert(key);
                ans.push_back(currArr);
            }
            return;
        }

        currArr.push_back(currEle);
        backtrack(ans, seen, currEle + 1, currArr, currSum + currEle, sum, count + 1, maxCount);
        currArr.pop_back();

        backtrack(ans, seen, currEle + 1, currArr, currSum, sum, count, maxCount);
    }

    vector<vector<int>> combinationSum3(int k, int n) {
        vector<vector<int>> ans;
        unordered_set<string> seen;
        vector<int> currArr;

        backtrack(ans, seen, 1, currArr, 0, n, 0, k);
        return ans;
    }
};
