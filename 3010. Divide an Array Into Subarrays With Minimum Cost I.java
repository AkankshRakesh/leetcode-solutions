class Solution {
    public int minimumCost(int[] nums) {
        int first = nums[1] > nums[2] ? nums[2] : nums[1], second = nums[1] < nums[2] ? nums[2] : nums[1];
        for(int i = 3; i < nums.length; i++){
            if(nums[i] < first){
                second = first;
                first = nums[i];
            }
            else if(nums[i] < second){
                second = nums[i];
            }
        }

        return nums[0] + first + second;
    }
}