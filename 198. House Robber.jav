class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] track = new int[n + 1];

        track[0] = nums[0];
        track[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++){
            track[i] = Math.max(track[i - 2] + nums[i], track[i - 1]);
        }

        return track[n - 1];
    }
}