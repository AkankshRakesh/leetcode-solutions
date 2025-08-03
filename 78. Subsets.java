class Solution {
public:
    void backtrack(vector<vector<int>>& arr, vector<int>& temp, vector<int>& nums, int ind, int n) {
        if (ind >= n) {
            arr.push_back(temp);
            return;
        }

        temp.push_back(nums[ind]);
        backtrack(arr, temp, nums, ind + 1, n);

        temp.pop_back();
        backtrack(arr, temp, nums, ind + 1, n);
    }

    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> arr;
        vector<int> temp;
        backtrack(arr, temp, nums, 0, nums.size());
        return arr;
    }
};
