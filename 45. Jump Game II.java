class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0;
        int left = 0, right = 0;
        while (right < n - 1) {
            int nextRight = right;
            while(left <= right && left < n - 1){
                nextRight = Math.max(nextRight, nums[left] + left);
                left++;
            }
            jumps++;
            left = right + 1;
            right = nextRight;
        }
        return jumps;
    }
}