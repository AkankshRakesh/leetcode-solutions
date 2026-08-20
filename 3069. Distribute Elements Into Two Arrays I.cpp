class Solution {
public:
    vector<int> resultArray(vector<int>& nums) {
        int last1 = 0, last2 = 1;
        vector<int> res(nums.size());
        res[0] = nums[0];
        nums[0] = -1;

        for (int i = 2; i < nums.size(); i++) {
            if (res[last1] > nums[last2]) {
                last1++;
                res[last1] = nums[i];
                nums[i] = -1;
            }
            else {
                last2 = i;
            }
        }

        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] != -1) {
                last1++;
                res[last1] = nums[i];
            }
        }

        return res;
    }
};