class Solution {
public:
    long long count(vector<int> nums, int sum){
        long long res = 0;
        int i = 0, j = nums.size() - 1;
        while(i <= j){
            if(nums[i] + nums[j] < sum){
                res += j - i;
                i++;
            }
            else j--;
        }
        return res;
    }
    long long countFairPairs(vector<int>& nums, int lower, int upper) {
        sort(nums.begin(), nums.end());
        return count(nums, upper + 1) - count(nums, lower);
    }
};