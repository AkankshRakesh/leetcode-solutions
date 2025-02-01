class Solution {
    public boolean isArraySpecial(int[] nums) {
        int n = nums.length;
        boolean nextEven = true;
        if(nums[0] % 2 == 0) nextEven = false;

        for(int i = 1; i < n; i++){
            if(nextEven && nums[i] % 2 != 0) return false;
            else if(!nextEven && nums[i] % 2 == 0) return false;
            nextEven = !nextEven;
        }
        return true;
    }
}