class Solution {
public:
    int minMoves(vector<int>& nums) {
        int min = nums[0];
        for(int num : nums) min = min > num ? num : min;

        int ans = 0;
        for(int num : nums){
            ans += num - min;
        }

        return ans;
    }
};