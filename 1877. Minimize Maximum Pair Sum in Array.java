class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int ans = 0;
        while(left < right){
            ans = Math.max(ans, nums[left] + nums[right]);
            left++;
            right--;
        }

        return ans;
    }
}