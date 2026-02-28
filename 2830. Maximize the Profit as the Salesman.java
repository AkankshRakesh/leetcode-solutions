class Solution {
    public int findIndex(List<List<Integer>> offers, int index){
        int left = index + 1, right = offers.size() - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(offers.get(mid).get(0) > offers.get(index).get(1)) right = mid - 1;
            else left = mid + 1;
        }

        return left;
    }
    public int solve(List<List<Integer>> offers, int[] dp, int index){
        if(index >= offers.size()) return 0;
        if(dp[index] != -1) return dp[index];

        int nextInd = findIndex(offers, index);
        int pick = offers.get(index).get(2) + solve(offers, dp, nextInd);
        int notPick = solve(offers, dp, index + 1);

        return dp[index] = Math.max(pick, notPick);
    }
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        Collections.sort(offers, (a, b) -> Integer.compare(a.get(0), b.get(0)));
        int[] dp = new int[offers.size()];
        Arrays.fill(dp, -1);

        return solve(offers, dp, 0);
    }
}