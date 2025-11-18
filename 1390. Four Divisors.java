class Solution {
    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        for(int num : nums){
            int currSum = 0;
            boolean found = false;
            for(int i = 2; i * i <= num; i++){
                if(i * i == num){
                    found = false;
                    break;
                }
                if(num % i == 0){
                    if(found){
                        found = false;
                        break;
                    }
                    found = true;
                    currSum += (i + (num / i));
                }
            }
            if(found) ans += (currSum + 1 + num);
        }

        return ans;
    }
}