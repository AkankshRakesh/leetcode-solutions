class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        int ans = 0;
        for(int cost : costs){
            coins -= cost;
            if(coins < 0) break;
            ans++;
        }

        return ans;
    }
}