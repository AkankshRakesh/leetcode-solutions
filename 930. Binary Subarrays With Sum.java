class Solution {
    public int solve(int[] nums, int goal){
        int sum = 0;
        int left = 0;
        int ans = 0;
        for(int right = 0; right < nums.length; right++){
            sum += nums[right];
            
            while(sum > goal && left <= right){
                sum -= nums[left];
                left++;
            }

            ans += (right - left);
        }

        return ans;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return solve(nums, goal) - solve(nums, goal - 1);
    }
}