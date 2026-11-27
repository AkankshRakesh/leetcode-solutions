class Solution {
    public int dfs(int[][] items, int index, int budget, int[] divides, int canGetCopies, int[][][] dp){
        if(index >= items.length) return 0;

        if(dp[index][budget][canGetCopies] != -1) return dp[index][budget][canGetCopies];

        int cost = items[index][1];
        int pick = Integer.MIN_VALUE;
        if(budget - cost >= 0){
            pick = Math.max(dfs(items, index, budget - cost, divides, 0, dp), dfs(items, index + 1, budget - cost, divides, 1, dp)) + 1;
            if(canGetCopies == 1) pick += divides[index];
        }

        int notPick = dfs(items, index + 1, budget, divides, 1, dp);

        return dp[index][budget][canGetCopies] = Math.max(pick, notPick);
    }
    public int maximumSaleItems(int[][] items, int budget) {
        int[] divides = new int[items.length];
        for(int i = 0; i < items.length; i++){
            int count = 0;
            for(int j = 0; j < items.length; j++){
                if(i == j) continue;
                if(items[j][0] % items[i][0] == 0) count++;
            }
            divides[i] = count;
        }

        int[][][] dp = new int[items.length][budget + 1][2];
        for(int i = 0; i < items.length; i++){
            for(int j = 0; j <= budget; j++) Arrays.fill(dp[i][j], -1);
        }

        return dfs(items, 0, budget, divides, 1, dp);
    }
}