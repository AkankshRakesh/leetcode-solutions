class Solution {
public:
    long long zeroFilledSubarray(vector<int>& nums) {
        long long n = nums.size();
        long long left = 0;
        long long ans = 0;

        for(long long right = 1; right < n; right++){
            while(left < right && nums[left] != 0) left++;
            if(nums[right] != 0 && right - left > 0){
                long long ele = right - left;
                ans += (right - left);
                ans += ((ele * (ele - 1)) / 2);
                left = right;
            }
        }

        if(nums[n - 1] == 0 && n - left > 0){
            long long ele = n - left;
            ans += (n - left);
            ans += ((ele * (ele - 1)) / 2);
        }

        return ans;
    }
};
