class Solution {
    public int findIndex(int[][] rides, int index){
        int left = index + 1, right = rides.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(rides[mid][0] >= rides[index][1]) right = mid - 1;
            else left = mid + 1;
        }

        return left;
    }
    public long solve(int[][] rides, long[] dp, int index){
        if(index >= rides.length) return 0;
        if(dp[index] != -1) return dp[index];

        int nextInd = findIndex(rides, index);
        long pick = (rides[index][1] - rides[index][0] + rides[index][2]) + solve(rides, dp, nextInd);
        long notPick = solve(rides, dp, index + 1);

        return dp[index] = Math.max(pick , notPick);
    }
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, (a, b) -> Integer.compare(a[0], b[0]));
        long[] dp = new long[rides.length];
        Arrays.fill(dp, -1);

        return solve(rides, dp, 0);
    }
}