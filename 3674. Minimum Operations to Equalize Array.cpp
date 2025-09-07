class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int target = nums[0];
        for(int i = 1; i < n; i++) target &= nums[i];

        boolean eq = true;
        for(int i = 0; i < n; i++) if(nums[i] != target) { eq = false; break;}
        if(eq) return 0;

        return 1;
    }
}