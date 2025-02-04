class Solution {
public:
    int maxAscendingSum(vector<int>& nums) {
        int sum = nums[0], maxSum = nums[0], n = nums.size();
        for(int i = 1; i < n; i++){
            if(nums[i] > nums[i - 1]) sum += nums[i];
            else sum = nums[i];

            maxSum = maxSum > sum ? maxSum : sum;
        }
        return maxSum;
    }
};