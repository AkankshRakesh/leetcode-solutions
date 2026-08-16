class Solution {
    public boolean dfs(int c0, int c1, int c2, boolean aTurn, long sum){
        if(sum % 3 == 2){
            if(c2 != 0) return dfs(c0, c1, c2 - 1, !aTurn, sum + 2);
            else if(c0 != 0) return dfs(c0 - 1, c1, c2, !aTurn, sum);
            return aTurn;
        }
        
        if(c1 != 0) return dfs(c0, c1 - 1, c2, !aTurn, sum + 1);
        else if(c0 != 0) return dfs(c0 - 1, c1, c2, !aTurn, sum);
        return aTurn;
    }

    public boolean stoneGameIX(int[] stones) {
        int c2 = 0, c1 = 0, c0 = 0;
        int n = stones.length;
        for(int stone : stones){
            if(stone % 3 == 2) c2++;
            else if(stone % 3 == 1) c1++;
            else c0++;
        }

        if (c0 % 2 == 0) {
            return c1 >= 1 && c2 >= 1;
        }
        return c1 - c2 > 2 || c2 - c1 > 2;
    }
}