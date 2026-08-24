class Solution {
    public int stoneGameVIII(int[] stones) {
        int[] prefix = new int[stones.length];
        prefix[0] = stones[0];

        for(int i = 1; i < stones.length; i++){
            prefix[i] = prefix[i - 1] + stones[i];
        }

        int ans = prefix[stones.length - 1];
        for(int i = stones.length - 2; i >= 1; i--){
            ans = Math.max(ans, prefix[i] - ans);
        }

        return ans;        
    }
}