class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int tot = 0;
        for(int i = 0; i < n; i++) tot += gas[i] - cost[i];
        if(tot < 0) return -1;
        tot = 0;
        int ans = 0;
        for(int i = 0; i < n; i++){
            int diff = gas[i] - cost[i];
            tot += diff;
            if(tot < 0){
                ans = i + 1;
                tot = 0;
            }
        }

        return ans;
    }
} 