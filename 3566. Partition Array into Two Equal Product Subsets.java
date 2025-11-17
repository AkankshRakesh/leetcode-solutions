class Solution {
    public boolean backtrack(int[] nums, int index, long target, long currMult){
        if(currMult == target) return true;
        if(index >= nums.length || currMult > target) return false;

        return backtrack(nums, index + 1, target, currMult * nums[index]) || backtrack(nums, index + 1, target, currMult);
    }
    public boolean checkEqualPartitions(int[] nums, long target) {
        // if(target % 2 != 0) return false;
        long mult = 1;
        for(int num : nums) mult *= num;
        if(mult != target * target) return false;

        return backtrack(nums, 0, target, 1);
    }
}