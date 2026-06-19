class Solution {
    public int largestAltitude(int[] gain) {
        int ans = 0, curr = 0;
        for(int currGain : gain){
            curr += currGain;
            ans = Math.max(ans, curr);
        }

        return ans;
    }
}