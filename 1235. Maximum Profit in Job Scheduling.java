class Solution {
    public int pickInd(int[][] nums, int index){
        int left = index, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[index - 1][1] <= nums[mid][0]){
                right = mid - 1;
            }
            else left = mid + 1;
        }

        return left;
    }
    public int dfs(int[][] nums, int[] dp, int index){
        if(index >= nums.length) return 0;
        if(dp[index] != -1) return dp[index];

        int notPick = dfs(nums, dp, index + 1);
        int nextIndex = pickInd(nums, index + 1);
        int pick = nums[index][2] + dfs(nums, dp, nextIndex);

        return dp[index] = Math.max(pick, notPick);
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] nums = new int[startTime.length][3];
        for(int i = 0; i < startTime.length; i++){
            nums[i][0] = startTime[i];
            nums[i][1] = endTime[i];
            nums[i][2] = profit[i];
        }
        Arrays.sort(nums, (a, b) -> Integer.compare(a[0], b[0]));
        int[] dp = new int[startTime.length];
        Arrays.fill(dp, -1);
        
        int ans = 0;
        for(int i = 0; i < startTime.length; i++){
            ans = Math.max(ans, dfs(nums, dp, i));
        }

        return ans;
    }
}