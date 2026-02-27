class Solution {
    public int solve(int[][][] dp, ArrayList<Integer> digits, int index, int limit, int ones){
        if(index >= digits.size()) return ones;
        if(dp[index][limit][ones] != -1) return dp[index][limit][ones];

        int end = limit == 1 ? digits.get(index) : 9;
        int ans = 0;
        for(int i = 0; i <= end; i++){
            int nextLimit = limit == 1 && i == end ? 1 : 0;
            ans += solve(dp, digits, index + 1, nextLimit, ones + (i == 1 ? 1 : 0));
        }

        return dp[index][limit][ones] = ans;
    }
    public int countDigitOne(int n) {
        ArrayList<Integer> digits = new ArrayList<>();
        while(n != 0){
            digits.add(n % 10);
            n /= 10;
        }
        Collections.reverse(digits);
        int[][][] dp = new int[digits.size()][2][digits.size()];
        for(int i = 0; i < digits.size(); i++){
            Arrays.fill(dp[i][0], -1);
            Arrays.fill(dp[i][1], -1);
        }
   
        return solve(dp, digits, 0, 1, 0);
    }
}