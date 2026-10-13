class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = (nums.length / 2);
        long ans = 0;

        for(int i = 0; i < nums.length; i++){
            nums[i] = Math.abs(nums[i]);
        }

        Arrays.sort(nums);

        for(int i = nums.length - 1; i >= n; i--){
            ans += (long)nums[i] * (long)nums[i];
        }
        for(int i = n - 1; i >= 0; i--){
            ans -= (long)nums[i] * (long)nums[i];
        }

        return ans;
    }
}