class Solution {
public:
    int waysToSplitArray(vector<int>& nums) {
        int n = nums.size();
        long long sum = 0;
        for_each(nums.begin(), nums.end(), [&sum](int i) { 
               sum += i; 
             });

        int ans = 0;
        long long leftSum = 0;
        for(int i = 0; i < n - 1; i++){
            sum -= nums[i];
            leftSum += nums[i];
            if(leftSum >= sum) ans++;
        }

        return ans;
    }
};