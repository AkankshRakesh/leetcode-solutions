class Solution {
public:
    int minimumSubarrayLength(vector<int>& nums, int k) {
        int n = nums.size(); 
        vector<int> setBitCount(32, 0);
        
        int bitwiseOR = 0; 
        int left = 0; 
        int ans = INT_MAX; 

        for (int i = 0; i < n; i++) {
            bitwiseOR |= nums[i];
            
            for (int bit = 0; bit < 32; bit++) {
                if (nums[i] & (1 << bit)) {
                    setBitCount[bit]++;
                }
            }
            
            while (left <= i && bitwiseOR >= k) {
                ans = min(ans, i - left + 1);
                
                int updatedBitwiseOR = 0;
                for (int bit = 0; bit < 32; bit++) {
                    if (nums[left] & (1 << bit)) {
                        setBitCount[bit]--;
                    }
                    if (setBitCount[bit]) {
                        updatedBitwiseOR |= (1 << bit);
                    }
                }
                bitwiseOR = updatedBitwiseOR;
                left++;
            }
        }
        
        return ans == INT_MAX ? -1 : ans;
    }
};