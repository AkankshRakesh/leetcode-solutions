class Solution {
public:
    void backtrack(vector<int>& nums, int index, int n, vector<vector<int>>& arr,
                   vector<int>& currArr, set<vector<int>>& hs) {
        if (index >= n) {
            if (currArr.size() >= 2 && hs.find(currArr) == hs.end()) {
                arr.push_back(currArr);
                hs.insert(currArr);
            }
            return;
        }

        int size = currArr.size();
        if (size >= 1) {
            if (currArr[size - 1] <= nums[index]) {
                currArr.push_back(nums[index]);
                backtrack(nums, index + 1, n, arr, currArr, hs);
                currArr.pop_back();
            }
            backtrack(nums, index + 1, n, arr, currArr, hs);
        } else {
            currArr.push_back(nums[index]);
            backtrack(nums, index + 1, n, arr, currArr, hs);
            currArr.pop_back();
            backtrack(nums, index + 1, n, arr, currArr, hs);
        }
    }

    vector<vector<int>> findSubsequences(vector<int>& nums) {
        vector<vector<int>> arr;
        vector<int> currArr;
        set<vector<int>> hs;
        backtrack(nums, 0, nums.size(), arr, currArr, hs);
        return arr;
    }
};
