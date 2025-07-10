class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int maxEle = costs[0];
        int n = costs.length;
        for(int i = 1; i < n; i++) if(maxEle < costs[i]) maxEle = costs[i];

        int[] countArr = new int[maxEle + 1];

        for(int i = 0; i < n; i++) countArr[costs[i]]++;
        for(int i = 1; i <= maxEle; i++) countArr[i] += countArr[i - 1];

        int[] sortedArr = new int[n];
        for(int i = n - 1; i >= 0; i--){
            sortedArr[countArr[costs[i]] - 1] = costs[i];
            countArr[costs[i]]--;
        }

        int ans = 0;
        int costCount = 0;
        for(int i = -1; i < n - 1; i++){
            if(costCount + sortedArr[i + 1] > coins) return ans;
            costCount += sortedArr[i + 1];
            ans++;
        }
        return ans;
    }
}