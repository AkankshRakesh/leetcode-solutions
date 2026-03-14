class Solution {
    public int pickOrNot(int[] stones, int index, int[][] dp, int curr){
        if(index >= stones.length){
            if(curr < 0) return Integer.MAX_VALUE;
            return curr;
        }
        if(dp[index][curr] != -1) return dp[index][curr];

        return dp[index][curr] = Math.min(pickOrNot(stones, index + 1, dp, curr + stones[index]), pickOrNot(stones, index + 1, dp, Math.abs(curr - stones[index])));
    }
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for(int stone : stones) sum += stone;
        int[][] dp = new int[n][sum + 1];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);

        return pickOrNot(stones, 0, dp, 0);
    }
}