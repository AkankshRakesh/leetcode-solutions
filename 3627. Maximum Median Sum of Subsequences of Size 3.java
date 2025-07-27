class Solution {
    public long maximumMedianSum(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        long sum = 0;
        int k = n / 3;
        
        for(int i = n - 2; k > 0; i -= 2, k--){
            sum += nums[i];
        }

        return sum;
    }
}