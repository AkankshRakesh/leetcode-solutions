class Solution {
    public int countHillValley(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i = 1; i < n - 1; i++){
            if(nums[i] == nums[i + 1]) continue;

            if(nums[i] < nums[i + 1]){
                boolean res = false;
                for(int j = i - 1; j >= 0; j--){
                    if(nums[j] == nums[i]) continue;
                    if(nums[j] > nums[i]){
                        res = true;
                        break;
                    }
                    else break;
                }
                if(res) ans++;
            }
            if(nums[i] > nums[i + 1]){
                boolean res = false;
                for(int j = i - 1; j >= 0; j--){
                    if(nums[j] == nums[i]) continue;
                    if(nums[j] < nums[i]){
                        res = true;
                        break;
                    }
                    else break;
                }
                if(res) ans++;
            }
        }

        return ans;
    }
}