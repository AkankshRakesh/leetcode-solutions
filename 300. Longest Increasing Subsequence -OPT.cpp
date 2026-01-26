class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        vector<int> arr;
        arr.push_back(nums[0]);
        for (int i = 1; i < (int)nums.size(); i++) {
            if (arr.back() < nums[i]) arr.push_back(nums[i]);
            else {
                int left = 0;
                int right = (int)arr.size();
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (arr[mid] >= nums[i]) right = mid;
                    else left = mid + 1;
                }
                if (left < (int)arr.size()) arr[left] = nums[i];
            }
        }
        return (int)arr.size();
    }
};