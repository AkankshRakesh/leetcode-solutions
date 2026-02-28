class Solution {
    public int findIndex(int[][] events, int index){
        int left = index + 1, right = events.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(events[mid][0] > events[index][1]) right = mid - 1;
            else left = mid + 1;
        }

        return left;
    }
    public int solve(int[][] events, int[][] dp, int index, int k){
        if(index >= events.length || k == 0) return 0;
        if(dp[index][k] != -1) return dp[index][k];

        int nextInd = findIndex(events, index);
        int pick = events[index][2] + solve(events, dp, nextInd, k - 1);
        int notPick = solve(events, dp, index + 1, k);

        return dp[index][k] = Math.max(pick, notPick);
    }
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        int[][] dp = new int[events.length][3];
        for(int i = 0; i < events.length; i++) Arrays.fill(dp[i], -1);

        return solve(events, dp, 0, 2);
    }
}