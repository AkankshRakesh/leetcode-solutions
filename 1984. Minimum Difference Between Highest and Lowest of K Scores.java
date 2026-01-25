class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = k;
        int ans = Integer.MAX_VALUE;
        while(right <= nums.length){
            ans = Math.min(ans, nums[right - 1] - nums[left]);
            left++;
            right++;
        }

        return ans;
    }
}