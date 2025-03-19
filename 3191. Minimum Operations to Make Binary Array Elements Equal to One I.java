class Solution {
    public int minOperations(int[] nums) {
        int count = 0, n = nums.length;
        for(int i = 0; i < n - 2; i++){
            if(nums[i] == 0){
                nums[i] = 1 - nums[i];
                nums[i + 1] = 1 - nums[i + 1];
                nums[i + 2] = 1 - nums[i + 2];
                count += 1;
            }
        }
        if(nums[n - 1] == 0 || nums[n - 2] == 0 || nums[n - 3] == 0) return -1;
        return count;
    }
}