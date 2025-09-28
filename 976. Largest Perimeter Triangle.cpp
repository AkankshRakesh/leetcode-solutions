class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for(int i = nums.length - 1; i >= 2; i--){
            int x = nums[i - 2];
            int y = nums[i - 1];
            int z = nums[i];
            if(x + y > z) ans = Math.max(ans, x + y + z);
        }

        return ans;
    }
}