class Solution {
public:
    void backtrack(vector<int>& nums, vector<vector<int>>& res, int ind, vector<int>& currArr, set<vector<int>>& hs) {
        if (ind >= nums.size()) {
            if (hs.find(currArr) != hs.end()) return;
            hs.insert(currArr);
            res.push_back(currArr);
            return;
        }

        currArr.push_back(nums[ind]);
        backtrack(nums, res, ind + 1, currArr, hs);

        currArr.pop_back();
        backtrack(nums, res, ind + 1, currArr, hs);
    }

    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        sort(nums.begin(), nums.end());

        int n = nums.size();
        vector<vector<int>> res;
        set<vector<int>> hs;

        res.push_back({});

        for (int i = 0; i < n; i++) {
            if (i == 0 || (i > 0 && nums[i - 1] != nums[i])) {
                vector<int> temp;
                temp.push_back(nums[i]);
                backtrack(nums, res, i + 1, temp, hs);
            }
        }

        return res;
    }
};
