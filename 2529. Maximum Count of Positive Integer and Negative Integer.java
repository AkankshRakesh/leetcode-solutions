class Solution {
    public int maximumCount(int[] nums) {
        int countNeg = 0, countPos = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0) countPos++;
            else if(nums[i] < 0) countNeg++;
        }
        return countPos > countNeg ? countPos : countNeg;
    }
}