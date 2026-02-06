class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0;
        int ans = 0;
        for(int right = 0; right < nums.length; right++){
            while(nums[right] > (long)nums[left] * k && left < right) left++;

            ans = Math.max(ans, right - left + 1);
        }
        // ans = Math.max(ans, nums.length - left - 1);

        return nums.length - ans;
    }
}