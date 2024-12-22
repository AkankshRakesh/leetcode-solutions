class Solution {
public:
    int countSubarrays(vector<int>& nums) {
        int left = 0, right = 2, c = 0;
        while(right < nums.size()){
            if(nums[left] + nums[right] == 0.5 * nums[left + 1]) c++;
            left++;
            right++;
        }
        return c;
    }
};