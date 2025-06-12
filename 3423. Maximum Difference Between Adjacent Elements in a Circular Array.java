class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int ans = 0, n = nums.length;
        for(int i = 0; i < n - 1; i++){
            int temp = nums[i] - nums[i + 1];
            if(temp < 0) temp = -temp;

            if(temp > ans) ans = temp;
        }
        int temp = nums[0] - nums[n - 1];
        if(temp < 0) temp = -temp;

        if(temp > ans) ans = temp;

        return ans;
    }
}