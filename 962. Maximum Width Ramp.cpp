class Solution {
public:
    int maxWidthRamp(vector<int>& nums) {
        stack<int> s;
        int n = nums.size();
        for(int i = 0; i < n; i++){
            if(s.empty() || nums[i] < nums[s.top()]){
                s.push(i);
                if(nums[i] == 0) break;
            }
        }
        int maxW = 0;
        for(int j = n - 1; j >= 0; j--){
            while(!s.empty() && nums[s.top()] <= nums[j]){
                maxW = max(maxW, j - s.top());
                s.pop();
            }
            
        }
        return maxW;
    }
};