class Solution {
    public boolean canJump(int[] nums) {
        int ind = nums.length - 1;
        for(int i = nums.length - 2; i >= 0; i--){
            if(i + nums[i] >= ind) ind = i;
        }
        System.out.println(ind);
        if(ind == 0) return true;
        return false;
    }
}