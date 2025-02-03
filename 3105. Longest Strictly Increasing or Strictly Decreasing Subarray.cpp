class Solution {
public:
    int longestMonotonicSubarray(vector<int>& nums) {
        int incCount = 1, decCount = 1, n = nums.size(), maxIncCount = 1, maxDecCount = 1;
        for(int i = 1; i < n; i++){
            if(nums[i] > nums[i - 1]){
                incCount++;
                decCount = 1;
            }
            else if(nums[i] < nums[i - 1]){
                decCount++;
                incCount = 1;
            }
            else{
                decCount = 1;
                incCount = 1;
            }
            maxIncCount = maxIncCount > incCount ? maxIncCount : incCount;
            maxDecCount = maxDecCount > decCount ? maxDecCount : decCount;
        }
        return maxDecCount > maxIncCount ? maxDecCount : maxIncCount;
    }
};