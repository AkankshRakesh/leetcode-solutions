class Solution {
public:
    void backtrack(vector<int>& candidates, int target, vector<vector<int>>& arr,
                   int index, int n, int currSum, vector<int>& currArr) {
        if (index == n) {
            if (currSum == target) {
                arr.push_back(currArr);
            }
            return;
        }

        if (currSum == target) {
            arr.push_back(currArr);
            return;
        }
 
        if (currSum + candidates[index] > target) {
            return;
        }

        currArr.push_back(candidates[index]);
        backtrack(candidates, target, arr, index, n, currSum + candidates[index], currArr);
        currArr.pop_back();

        backtrack(candidates, target, arr, index + 1, n, currSum, currArr);
    }

    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end()); 
        vector<vector<int>> arr;
        vector<int> currArr;
        backtrack(candidates, target, arr, 0, candidates.size(), 0, currArr);
        return arr;
    }
};
