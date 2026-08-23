class Solution {
    public long count(int[] nums, int index, int balance, int tight, long[][][] dp){
        if(index >= nums.length) return balance == 0 ? 1 : 0;

        if(dp[index][balance + 100][tight] != -1) return dp[index][balance + 100][tight];

        long res = 0;
        if(tight == 1){
            for(int i = 0; i < nums[index]; i++){
                if(index % 2 == 0) res += count(nums, index + 1, balance + i, 0, dp);
                else res += count(nums, index + 1, balance - i, 0, dp);
            }
            if(index % 2 == 0) res += count(nums, index + 1, balance + nums[index], 1, dp);
            else res += count(nums, index + 1, balance - nums[index], 1, dp);
        } 
        else{
            for(int i = 0; i <= 9; i++){
                if(index % 2 == 0) res += count(nums, index + 1, balance + i, 0, dp);
                else res += count(nums, index + 1, balance - i, 0, dp);
            }
        }

        return dp[index][balance + 100][tight] = res;
    }
    public long countBalanced(long low, long high) {
        int digits = 0;
        long temp = low - 1;
        while(temp != 0){
            digits++;
            temp /= 10;
        }
        int[] lowNums = new int[digits];
        temp = low - 1;
        int index = digits - 1;
        while(temp != 0){
            lowNums[index] = (int)(temp % 10);
            temp /= 10;
            index--;
        }

        digits = 0;
        temp = high;
        while(temp != 0){
            digits++;
            temp /= 10;
        }

        int[] highNums = new int[digits];
        temp = high;
        index = digits - 1;
        while(temp != 0){
            highNums[index] = (int)(temp % 10);
            temp /= 10;
            index--;
        }

        long[][][] dp1 = new long[lowNums.length][300][2];
        for(int i = 0; i < lowNums.length; i++){
            for(int j = 0; j < 300; j++) Arrays.fill(dp1[i][j], -1);
        }
        long[][][] dp2 = new long[highNums.length][300][2];
        for(int i = 0; i < highNums.length; i++){
            for(int j = 0; j < 300; j++) Arrays.fill(dp2[i][j], -1);
        }

        return count(highNums, 0, 0, 1, dp2) - count(lowNums, 0, 0, 1, dp1);
    }
}