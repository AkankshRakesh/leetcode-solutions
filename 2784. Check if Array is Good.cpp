class Solution {
    public boolean isGood(int[] nums) {
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        if(nums.length != max + 1) return false;
        if(nums.length == 1 || max != nums[nums.length - 2] || nums[0] != 1) return false;

        for(int i = 1; i < nums.length - 2; i++){
            if(nums[i] == nums[i - 1] || nums[i] == max || nums[i] != i + 1) return false;
        }

        return true;
    }
}