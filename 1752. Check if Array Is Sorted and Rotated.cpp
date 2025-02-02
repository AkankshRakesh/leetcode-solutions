class Solution {
public:
    bool check(vector<int>& nums) {
        int n = nums.size(), firstInd = 0;
        bool firstFound = false;
        for(int i = 1; i < n; i++){
            if(nums[i] < nums[i - 1] && !firstFound){
                firstFound = true;
                firstInd = i;
            }
            else if(nums[i] < nums[i - 1] && firstFound) return false;
        }
        if(!firstFound) return true;
        if(nums[n - 1] > nums[0]) return false;
        return true;
    }
};