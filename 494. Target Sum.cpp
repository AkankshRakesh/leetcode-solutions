class Solution {
public:
    int ans = 0;
    void calSum(vector<int>& nums,int i ,int sum,int target, int size){
        if(i == size){
            if(sum == target){
                ans++;
                return;
            }
        }
        else{
            calSum(nums, i + 1, nums[i] + sum, target, size);
            calSum(nums, i + 1, sum - nums[i], target, size);
        }
    }

    int findTargetSumWays(vector<int>& nums, int target) {
        int n = nums.size();
        calSum(nums, 0,0, target, n);
        return ans;
    }
};