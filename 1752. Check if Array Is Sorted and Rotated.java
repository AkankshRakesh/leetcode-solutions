class Solution {
    public boolean check(int[] nums) {
        int n = nums.length, firstInd = 0;
        boolean firstFound = false;
        for(int i = 1; i < n; i++){
            if(nums[i] < nums[i - 1] && !firstFound){
                firstFound = true;
                firstInd = i;
            }
            else if(nums[i] < nums[i - 1] && firstFound) return false;
        }
        if(!firstFound) return true;
        if(nums[n - 1] > nums[0]) return false;
        return true;
    }
}