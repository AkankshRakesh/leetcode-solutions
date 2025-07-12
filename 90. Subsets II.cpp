class Solution {
public:
    void backtrack(vector<int>& nums, int index, vector<int>& currArr,
                   vector<vector<int>>& arr, int n, set<vector<int>>& hs) {
        if (index == n) {
            if (hs.find(currArr) == hs.end()) {
                arr.push_back(currArr);
                hs.insert(currArr);
            }
            return;
        }

        currArr.push_back(nums[index]);
        backtrack(nums, index + 1, currArr, arr, n, hs);

        currArr.pop_back();

        backtrack(nums, index + 1, currArr, arr, n, hs);
    }

    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        vector<vector<int>> arr;
        set<vector<int>> hs;
        vector<int> currArr;
        sort(nums.begin(), nums.end()); // Important to avoid duplicate permutations
        backtrack(nums, 0, currArr, arr, nums.size(), hs);
        return arr;
    }
};
