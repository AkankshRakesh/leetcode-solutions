class Solution {
    public:
        bool isArraySpecial(vector<int>& nums) {
            bool nextEven = true;
            if(nums[0] % 2 == 0) nextEven = false;
            int n = nums.size();
            for(int i = 1; i < n; i++){
                if(!nextEven && nums[i] % 2 == 0) return false;
                else if(nextEven && (nums[i] % 2 != 0 || nums[i] == 1)) return false;
                nextEven = !nextEven;
            }
            return true;
        }
    };