class Solution {
public:
    vector<vector<int>> ans;

    void backtrack(vector<int>& nums, string currStr, vector<int>& currArr,
                   unordered_set<int>& takenInd, unordered_set<string>& addedPerms, int n) {

        bool lastEle = true;
        for (int i = 0; i < n; i++) {
            if (takenInd.find(i) == takenInd.end()) {
                lastEle = false;
                string nextStr = currStr + "#" + to_string(nums[i]);
                currArr.push_back(nums[i]);
                takenInd.insert(i);

                backtrack(nums, nextStr, currArr, takenInd, addedPerms, n);

                takenInd.erase(i);
                currArr.pop_back();
            }
        }

        if (lastEle) {
            if (addedPerms.find(currStr) == addedPerms.end()) {
                ans.push_back(currArr);
                addedPerms.insert(currStr);
            }
        }
    }

    vector<vector<int>> permuteUnique(vector<int>& nums) {
        unordered_set<int> takenInd;
        unordered_set<string> addedPerms;
        int n = nums.size();

        for (int i = 0; i < n; i++) {
            takenInd.insert(i);
            vector<int> currArr = {nums[i]};
            string currStr = to_string(nums[i]);
            backtrack(nums, currStr, currArr, takenInd, addedPerms, n);
            takenInd.erase(i);
        }

        return ans;
    }
};