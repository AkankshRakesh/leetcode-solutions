class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = nums[0];
        int n = nums.length;
        for(int i = 1; i < n; i++){
            if(currSum > maxSum) maxSum = currSum;
            if(currSum < 0){
                currSum = nums[i];
            }
            else{
                currSum += nums[i];
            }
        }
        if(currSum > maxSum) maxSum = currSum;
        return maxSum;
    }
}