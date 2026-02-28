class Solution {
    public int findIndex(int[][] rides, int index){
        int left = index + 1, right = rides.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(rides[mid][0] > rides[index][1]) right = mid - 1;
            else left = mid + 1;
        }

        return left;
    }

    public int solve(int[][] events, int k, int[][] dp, int index){
        if(index >= events.length || k == 0) return 0;
        if(dp[index][k] != -1) return dp[index][k];

        int nextInd = findIndex(events, index);
        int pick = events[index][2] + solve(events, k - 1, dp, nextInd);
        int notPick = solve(events, k, dp, index + 1);

        return dp[index][k] = Math.max(pick, notPick);
    }

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        int[][] dp = new int[events.length][k + 1];
        for(int i = 0; i < events.length; i++) Arrays.fill(dp[i], -1);

        return solve(events, k, dp, 0);
    }
}