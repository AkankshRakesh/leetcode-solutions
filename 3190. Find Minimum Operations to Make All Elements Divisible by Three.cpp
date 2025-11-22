class Solution {
public:
    int minimumOperations(vector<int>& nums) {
        int ans = 0;
        for(int num : nums) if(num % 3 != 0) ans++;
        return ans;
    }
};