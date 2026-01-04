class Solution {
    public int sumFourDivisors(int[] nums) {
        int maxNum = -1;
        for(int num : nums) maxNum = Math.max(maxNum, num);

        int divCount[] = new int[maxNum + 1];
        int divisors[][] = new int[maxNum + 1][2];
        for(int i = 2; i <= maxNum; i++){
            for(int j = i + i; j <= maxNum; j += i){
                divCount[j]++;
                if(divCount[j] == 1) divisors[j][0] = i;
                else divisors[j][1] = i;
            }
        }

        int ans = 0;
        for(int num : nums){
            if(divCount[num] == 2){
                ans += (1 + num + divisors[num][0] + divisors[num][1]);
            }
        }

        return ans;
    }
}